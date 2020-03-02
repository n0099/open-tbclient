package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private long aws;
    private long eOV;
    private long eUp;
    private int eUq;
    private int eUr;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.eUp = j;
        this.eUq = i;
        this.aws = j2;
        this.eOV = j3;
        this.eUr = i2;
        addParam("challenge_id", this.eUp);
        addParam("avts_conn", this.eUq);
        addParam("live_id", this.aws);
        addParam("anchor_id", this.eOV);
        addParam("avts_fail", this.eUr);
    }
}
