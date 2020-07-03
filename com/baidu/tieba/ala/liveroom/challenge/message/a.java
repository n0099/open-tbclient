package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private long aZe;
    private int blm;
    private long fTw;
    private long fYs;
    private int fZq;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.fYs = j;
        this.blm = i;
        this.aZe = j2;
        this.fTw = j3;
        this.fZq = i2;
        addParam("challenge_id", this.fYs);
        addParam("avts_conn", this.blm);
        addParam("live_id", this.aZe);
        addParam("anchor_id", this.fTw);
        addParam("avts_fail", this.fZq);
    }
}
