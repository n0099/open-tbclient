package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private long awr;
    private long eOU;
    private long eUo;
    private int eUp;
    private int eUq;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.eUo = j;
        this.eUp = i;
        this.awr = j2;
        this.eOU = j3;
        this.eUq = i2;
        addParam("challenge_id", this.eUo);
        addParam("avts_conn", this.eUp);
        addParam("live_id", this.awr);
        addParam("anchor_id", this.eOU);
        addParam("avts_fail", this.eUq);
    }
}
