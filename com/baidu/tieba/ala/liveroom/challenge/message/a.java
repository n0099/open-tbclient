package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private int bHI;
    private long bnV;
    private long fYr;
    private long gZp;
    private int hap;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.gZp = j;
        this.bHI = i;
        this.bnV = j2;
        this.fYr = j3;
        this.hap = i2;
        addParam("challenge_id", this.gZp);
        addParam("avts_conn", this.bHI);
        addParam("live_id", this.bnV);
        addParam("anchor_id", this.fYr);
        addParam("avts_fail", this.hap);
    }
}
