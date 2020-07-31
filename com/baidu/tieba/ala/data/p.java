package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class p extends HttpMessage {
    private long fJT;
    private long fJU;
    private String fJV;
    private String liveId;
    private String roomId;

    public p() {
        super(1021159);
    }

    public void dL(long j) {
        this.fJT = j;
    }

    public void dM(long j) {
        this.fJU = j;
    }

    public void CK(String str) {
        this.fJV = str;
    }

    public void eH(String str) {
        this.liveId = str;
    }

    public void fx(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.fJT);
        addParam("red_packet_num", this.fJU);
        addParam("condition", this.fJV);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
