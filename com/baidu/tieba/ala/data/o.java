package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes2.dex */
public class o extends HttpMessage {
    private long euT;
    private long euU;
    private String euV;
    private String liveId;
    private String roomId;

    public o() {
        super(1021156);
    }

    public void cC(long j) {
        this.euT = j;
    }

    public void cD(long j) {
        this.euU = j;
    }

    public void xH(String str) {
        this.euV = str;
    }

    public void dB(String str) {
        this.liveId = str;
    }

    public void dC(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.euT);
        addParam("red_packet_num", this.euU);
        addParam("condition", this.euV);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
