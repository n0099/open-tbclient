package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    private int bPS;
    private long bvY;
    private long gqJ;
    private long huC;
    private int hvC;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.huC = j;
        this.bPS = i;
        this.bvY = j2;
        this.gqJ = j3;
        this.hvC = i2;
        addParam("challenge_id", this.huC);
        addParam("avts_conn", this.bPS);
        addParam("live_id", this.bvY);
        addParam("anchor_id", this.gqJ);
        addParam("avts_fail", this.hvC);
    }
}
