package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private long aQm;
    private int aYJ;
    private long fug;
    private long fzy;
    private int fzz;

    public a(long j, int i, long j2, long j3, int i2) {
        super(1021112);
        this.fzy = j;
        this.aYJ = i;
        this.aQm = j2;
        this.fug = j3;
        this.fzz = i2;
        addParam("challenge_id", this.fzy);
        addParam("avts_conn", this.aYJ);
        addParam("live_id", this.aQm);
        addParam("anchor_id", this.fug);
        addParam("avts_fail", this.fzz);
    }
}
