package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class a extends HttpMessage {
    private long bey;
    private int brp;
    private long fuN;
    private long gpM;
    private int gqK;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.gpM = j;
        this.brp = i;
        this.bey = j2;
        this.fuN = j3;
        this.gqK = i2;
        addParam("challenge_id", this.gpM);
        addParam("avts_conn", this.brp);
        addParam("live_id", this.bey);
        addParam("anchor_id", this.fuN);
        addParam("avts_fail", this.gqK);
    }
}
