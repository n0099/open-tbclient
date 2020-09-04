package com.baidu.tbadk.mutiprocess.competetask;

import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes.dex */
public class CompeteTaskEvent extends SerializableEvent {
    public CompleteTaskToastData taskToastData;

    public CompeteTaskEvent() {
        setType(0);
    }
}
