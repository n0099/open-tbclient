package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes2.dex */
public class a extends HttpMessage {
    private long ash;
    private long eKV;
    private long eQx;
    private int eQy;
    private int eQz;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.eQx = j;
        this.eQy = i;
        this.ash = j2;
        this.eKV = j3;
        this.eQz = i2;
        addParam("challenge_id", this.eQx);
        addParam("avts_conn", this.eQy);
        addParam("live_id", this.ash);
        addParam("anchor_id", this.eKV);
        addParam("avts_fail", this.eQz);
    }
}
