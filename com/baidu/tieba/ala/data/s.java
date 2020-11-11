package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class s extends HttpMessage {
    private long gAM;
    private long gAN;
    private String gAO;
    private String liveId;
    private String roomId;

    public s() {
        super(1021159);
    }

    public void eE(long j) {
        this.gAM = j;
    }

    public void eF(long j) {
        this.gAN = j;
    }

    public void Ha(String str) {
        this.gAO = str;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.gAM);
        addParam("red_packet_num", this.gAN);
        addParam("condition", this.gAO);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
