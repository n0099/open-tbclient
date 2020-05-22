package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private long aWv;
    private int bgf;
    private long fIc;
    private long fNA;
    private int fNB;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.fNA = j;
        this.bgf = i;
        this.aWv = j2;
        this.fIc = j3;
        this.fNB = i2;
        addParam("challenge_id", this.fNA);
        addParam("avts_conn", this.bgf);
        addParam("live_id", this.aWv);
        addParam("anchor_id", this.fIc);
        addParam("avts_fail", this.fNB);
    }
}
