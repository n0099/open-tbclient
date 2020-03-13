package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class o extends HttpMessage {
    private long eAD;
    private long eAE;
    private String eAF;
    private String liveId;
    private String roomId;

    public o() {
        super(1021159);
    }

    public void cK(long j) {
        this.eAD = j;
    }

    public void cL(long j) {
        this.eAE = j;
    }

    public void yh(String str) {
        this.eAF = str;
    }

    public void dO(String str) {
        this.liveId = str;
    }

    public void dP(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.eAD);
        addParam("red_packet_num", this.eAE);
        addParam("condition", this.eAF);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
