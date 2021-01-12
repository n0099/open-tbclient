package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    private int bLg;
    private long brk;
    private long gmc;
    private long hpW;
    private int hqW;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.hpW = j;
        this.bLg = i;
        this.brk = j2;
        this.gmc = j3;
        this.hqW = i2;
        addParam("challenge_id", this.hpW);
        addParam("avts_conn", this.bLg);
        addParam("live_id", this.brk);
        addParam("anchor_id", this.gmc);
        addParam("avts_fail", this.hqW);
    }
}
