package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private int bLf;
    private long brr;
    private long ggl;
    private long hiH;
    private int hjH;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.hiH = j;
        this.bLf = i;
        this.brr = j2;
        this.ggl = j3;
        this.hjH = i2;
        addParam("challenge_id", this.hiH);
        addParam("avts_conn", this.bLf);
        addParam("live_id", this.brr);
        addParam("anchor_id", this.ggl);
        addParam("avts_fail", this.hjH);
    }
}
