package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private long bhr;
    private int buE;
    private long fxY;
    private long gta;
    private int gub;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.gta = j;
        this.buE = i;
        this.bhr = j2;
        this.fxY = j3;
        this.gub = i2;
        addParam("challenge_id", this.gta);
        addParam("avts_conn", this.buE);
        addParam("live_id", this.bhr);
        addParam("anchor_id", this.fxY);
        addParam("avts_fail", this.gub);
    }
}
