package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    private int bQq;
    private long bwn;
    private long gqI;
    private long hwd;
    private int hxd;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.hwd = j;
        this.bQq = i;
        this.bwn = j2;
        this.gqI = j3;
        this.hxd = i2;
        addParam("challenge_id", this.hwd);
        addParam("avts_conn", this.bQq);
        addParam("live_id", this.bwn);
        addParam("anchor_id", this.gqI);
        addParam("avts_fail", this.hxd);
    }
}
