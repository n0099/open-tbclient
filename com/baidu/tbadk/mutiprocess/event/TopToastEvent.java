package com.baidu.tbadk.mutiprocess.event;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes.dex */
public class TopToastEvent extends SerializableEvent {
    private String content;
    private int status;

    public TopToastEvent(int i, String str) {
        this.status = i;
        this.content = str;
    }

    public boolean isSuccess() {
        return this.status == 1;
    }

    public String getContent() {
        return this.content;
    }
}
