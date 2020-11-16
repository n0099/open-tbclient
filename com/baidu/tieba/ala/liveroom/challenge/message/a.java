package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private int bFX;
    private long bmk;
    private long fXY;
    private long gYW;
    private int gZW;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.gYW = j;
        this.bFX = i;
        this.bmk = j2;
        this.fXY = j3;
        this.gZW = i2;
        addParam("challenge_id", this.gYW);
        addParam("avts_conn", this.bFX);
        addParam("live_id", this.bmk);
        addParam("anchor_id", this.fXY);
        addParam("avts_fail", this.gZW);
    }
}
