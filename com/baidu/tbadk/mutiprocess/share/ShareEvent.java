package com.baidu.tbadk.mutiprocess.share;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes3.dex */
public class ShareEvent extends SerializableEvent {
    public int channel;
    public String extLiveInfo;
    public int status;
    public String tid;

    public ShareEvent() {
        setType(1);
    }
}
