package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private long blh;
    private int byG;
    private long fKh;
    private long gHv;
    private int gIw;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.gHv = j;
        this.byG = i;
        this.blh = j2;
        this.fKh = j3;
        this.gIw = i2;
        addParam("challenge_id", this.gHv);
        addParam("avts_conn", this.byG);
        addParam("live_id", this.blh);
        addParam("anchor_id", this.fKh);
        addParam("avts_fail", this.gIw);
    }
}
