package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private long aWv;
    private int bgf;
    private long fIn;
    private long fNL;
    private int fNM;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.fNL = j;
        this.bgf = i;
        this.aWv = j2;
        this.fIn = j3;
        this.fNM = i2;
        addParam("challenge_id", this.fNL);
        addParam("avts_conn", this.bgf);
        addParam("live_id", this.aWv);
        addParam("anchor_id", this.fIn);
        addParam("avts_fail", this.fNM);
    }
}
