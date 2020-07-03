package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class o extends HttpMessage {
    private String fEA;
    private long fEy;
    private long fEz;
    private String liveId;
    private String roomId;

    public o() {
        super(1021159);
    }

    public void dx(long j) {
        this.fEy = j;
    }

    public void dy(long j) {
        this.fEz = j;
    }

    public void BY(String str) {
        this.fEA = str;
    }

    public void eI(String str) {
        this.liveId = str;
    }

    public void fy(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.fEy);
        addParam("red_packet_num", this.fEz);
        addParam("condition", this.fEA);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
