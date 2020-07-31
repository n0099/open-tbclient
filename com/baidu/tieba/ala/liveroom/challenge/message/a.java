package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private long aZc;
    private int blG;
    private long fjn;
    private long gdz;
    private int gey;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.gdz = j;
        this.blG = i;
        this.aZc = j2;
        this.fjn = j3;
        this.gey = i2;
        addParam("challenge_id", this.gdz);
        addParam("avts_conn", this.blG);
        addParam("live_id", this.aZc);
        addParam("anchor_id", this.fjn);
        addParam("avts_fail", this.gey);
    }
}
