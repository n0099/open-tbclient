package com.baidu.tbadk.mutiprocess.event;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes3.dex */
public class TopToastEvent extends SerializableEvent {
    public String content;
    public int status;

    public TopToastEvent(int i, String str) {
        this.status = i;
        this.content = str;
    }

    public String getContent() {
        return this.content;
    }

    public boolean isSuccess() {
        return this.status == 1;
    }
}
