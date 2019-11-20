package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes6.dex */
public class a extends HttpMessage {
    private long aju;
    private long dUg;
    private long dZb;
    private int dZc;
    private int dZd;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.dZb = j;
        this.dZc = i;
        this.aju = j2;
        this.dUg = j3;
        this.dZd = i2;
        addParam("challenge_id", this.dZb);
        addParam("avts_conn", this.dZc);
        addParam("live_id", this.aju);
        addParam("anchor_id", this.dUg);
        addParam("avts_fail", this.dZd);
    }
}
