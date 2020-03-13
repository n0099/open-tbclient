package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private long awt;
    private long ePi;
    private long eUC;
    private int eUD;
    private int eUE;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.eUC = j;
        this.eUD = i;
        this.awt = j2;
        this.ePi = j3;
        this.eUE = i2;
        addParam("challenge_id", this.eUC);
        addParam("avts_conn", this.eUD);
        addParam("live_id", this.awt);
        addParam("anchor_id", this.ePi);
        addParam("avts_fail", this.eUE);
    }
}
