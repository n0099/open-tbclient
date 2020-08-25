package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class a extends HttpMessage {
    private long bew;
    private int brm;
    private long fuJ;
    private long gpI;
    private int gqG;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.gpI = j;
        this.brm = i;
        this.bew = j2;
        this.fuJ = j3;
        this.gqG = i2;
        addParam("challenge_id", this.gpI);
        addParam("avts_conn", this.brm);
        addParam("live_id", this.bew);
        addParam("anchor_id", this.fuJ);
        addParam("avts_fail", this.gqG);
    }
}
