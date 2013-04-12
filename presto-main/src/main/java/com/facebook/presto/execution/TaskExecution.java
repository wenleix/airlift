/*
 * Copyright 2004-present Facebook. All Rights Reserved.
 */
package com.facebook.presto.execution;

import com.facebook.presto.OutputBuffers;
import com.facebook.presto.TaskSource;
import com.facebook.presto.operator.Page;
import io.airlift.units.Duration;

import java.util.List;

public interface TaskExecution
{
    TaskId getTaskId();

    TaskInfo getTaskInfo(boolean full);

    void addSources(List<TaskSource> sources);

    void addResultQueue(OutputBuffers outputIds);

    void cancel();

    void fail(Throwable cause);

    BufferResult<Page> getResults(String outputId, int maxPageCount, Duration maxWait)
            throws InterruptedException;

    void abortResults(String outputId);

    void recordHeartBeat();
}