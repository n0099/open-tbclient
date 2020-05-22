package com.baidu.tieba.ala.anchortask.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private long aul;
    private long liveId;

    public a() {
        super(1021172);
    }

    public void af(long j) {
        this.aul = j;
    }

    public void setLiveId(long j) {
        this.liveId = j;
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("anchor_id", this.aul);
    }
}
