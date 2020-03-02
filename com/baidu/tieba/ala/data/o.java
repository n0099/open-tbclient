package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class o extends HttpMessage {
    private long eAq;
    private long eAr;
    private String eAs;
    private String liveId;
    private String roomId;

    public o() {
        super(1021159);
    }

    public void cK(long j) {
        this.eAq = j;
    }

    public void cL(long j) {
        this.eAr = j;
    }

    public void yg(String str) {
        this.eAs = str;
    }

    public void dO(String str) {
        this.liveId = str;
    }

    public void dP(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.eAq);
        addParam("red_packet_num", this.eAr);
        addParam("condition", this.eAs);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
