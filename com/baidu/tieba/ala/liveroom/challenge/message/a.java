package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private long aQg;
    private int aYE;
    private long fub;
    private long fzt;
    private int fzu;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.fzt = j;
        this.aYE = i;
        this.aQg = j2;
        this.fub = j3;
        this.fzu = i2;
        addParam("challenge_id", this.fzt);
        addParam("avts_conn", this.aYE);
        addParam("live_id", this.aQg);
        addParam("anchor_id", this.fub);
        addParam("avts_fail", this.fzu);
    }
}
