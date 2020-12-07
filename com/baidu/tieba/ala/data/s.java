package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class s extends HttpMessage {
    private long gJq;
    private long gJr;
    private String gJs;
    private String liveId;
    private String roomId;

    public s() {
        super(1021159);
    }

    public void fi(long j) {
        this.gJq = j;
    }

    public void fj(long j) {
        this.gJr = j;
    }

    public void Hp(String str) {
        this.gJs = str;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.gJq);
        addParam("red_packet_num", this.gJr);
        addParam("condition", this.gJs);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
