package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class s extends HttpMessage {
    private long gAt;
    private long gAu;
    private String gAv;
    private String liveId;
    private String roomId;

    public s() {
        super(1021159);
    }

    public void eE(long j) {
        this.gAt = j;
    }

    public void eF(long j) {
        this.gAu = j;
    }

    public void GB(String str) {
        this.gAv = str;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.gAt);
        addParam("red_packet_num", this.gAu);
        addParam("condition", this.gAv);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
