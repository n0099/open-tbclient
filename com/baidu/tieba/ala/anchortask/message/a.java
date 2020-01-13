package com.baidu.tieba.ala.anchortask.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes2.dex */
public class a extends HttpMessage {
    private long Vt;
    private long liveId;

    public a() {
        super(1021172);
    }

    public void cz(long j) {
        this.Vt = j;
    }

    public void setLiveId(long j) {
        this.liveId = j;
    }

    public void setParams() {
        addParam("live_id", this.liveId);
        addParam("anchor_id", this.Vt);
    }
}
