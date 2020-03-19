package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class o extends HttpMessage {
    private long eAZ;
    private long eBa;
    private String eBb;
    private String liveId;
    private String roomId;

    public o() {
        super(1021159);
    }

    public void cK(long j) {
        this.eAZ = j;
    }

    public void cL(long j) {
        this.eBa = j;
    }

    public void yi(String str) {
        this.eBb = str;
    }

    public void dN(String str) {
        this.liveId = str;
    }

    public void dO(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.eAZ);
        addParam("red_packet_num", this.eBa);
        addParam("condition", this.eBb);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
