package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes2.dex */
public class a extends HttpMessage {
    private long arv;
    private long eJK;
    private long eOY;
    private int eOZ;
    private int ePa;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.eOY = j;
        this.eOZ = i;
        this.arv = j2;
        this.eJK = j3;
        this.ePa = i2;
        addParam("challenge_id", this.eOY);
        addParam("avts_conn", this.eOZ);
        addParam("live_id", this.arv);
        addParam("anchor_id", this.eJK);
        addParam("avts_fail", this.ePa);
    }
}
