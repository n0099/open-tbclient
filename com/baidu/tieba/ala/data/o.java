package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class o extends HttpMessage {
    private long eAp;
    private long eAq;
    private String eAr;
    private String liveId;
    private String roomId;

    public o() {
        super(1021159);
    }

    public void cK(long j) {
        this.eAp = j;
    }

    public void cL(long j) {
        this.eAq = j;
    }

    public void yg(String str) {
        this.eAr = str;
    }

    public void dO(String str) {
        this.liveId = str;
    }

    public void dP(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.eAp);
        addParam("red_packet_num", this.eAq);
        addParam("condition", this.eAr);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
