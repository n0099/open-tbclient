package com.baidu.tbadk.mutiprocess.history;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes2.dex */
public class HistoryEvent extends SerializableEvent {
    public String tid;

    public HistoryEvent() {
        setType(1);
    }
}
