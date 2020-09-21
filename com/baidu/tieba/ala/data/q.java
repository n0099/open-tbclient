package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class q extends HttpMessage {
    private long fYB;
    private long fYC;
    private String fYD;
    private String liveId;
    private String roomId;

    public q() {
        super(1021159);
    }

    public void dY(long j) {
        this.fYB = j;
    }

    public void dZ(long j) {
        this.fYC = j;
    }

    public void FE(String str) {
        this.fYD = str;
    }

    public void gi(String str) {
        this.liveId = str;
    }

    public void hg(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.fYB);
        addParam("red_packet_num", this.fYC);
        addParam("condition", this.fYD);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
