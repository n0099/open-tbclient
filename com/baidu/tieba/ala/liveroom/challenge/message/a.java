package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private long awD;
    private long ePG;
    private long eVa;
    private int eVb;
    private int eVc;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.eVa = j;
        this.eVb = i;
        this.awD = j2;
        this.ePG = j3;
        this.eVc = i2;
        addParam("challenge_id", this.eVa);
        addParam("avts_conn", this.eVb);
        addParam("live_id", this.awD);
        addParam("anchor_id", this.ePG);
        addParam("avts_fail", this.eVc);
    }
}
