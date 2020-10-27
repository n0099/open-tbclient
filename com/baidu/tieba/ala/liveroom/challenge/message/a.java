package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private int bBC;
    private long bmB;
    private long fSB;
    private long gTk;
    private int gUl;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.gTk = j;
        this.bBC = i;
        this.bmB = j2;
        this.fSB = j3;
        this.gUl = i2;
        addParam("challenge_id", this.gTk);
        addParam("avts_conn", this.bBC);
        addParam("live_id", this.bmB);
        addParam("anchor_id", this.fSB);
        addParam("avts_fail", this.gUl);
    }
}
