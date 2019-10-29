package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes6.dex */
public class a extends HttpMessage {
    private long ajM;
    private long dUX;
    private long dZS;
    private int dZT;
    private int dZU;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.dZS = j;
        this.dZT = i;
        this.ajM = j2;
        this.dUX = j3;
        this.dZU = i2;
        addParam("challenge_id", this.dZS);
        addParam("avts_conn", this.dZT);
        addParam("live_id", this.ajM);
        addParam("anchor_id", this.dUX);
        addParam("avts_fail", this.dZU);
    }
}
