package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    private int bOQ;
    private long buN;
    private long goZ;
    private long huu;
    private int hvu;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.huu = j;
        this.bOQ = i;
        this.buN = j2;
        this.goZ = j3;
        this.hvu = i2;
        addParam("challenge_id", this.huu);
        addParam("avts_conn", this.bOQ);
        addParam("live_id", this.buN);
        addParam("anchor_id", this.goZ);
        addParam("avts_fail", this.hvu);
    }
}
