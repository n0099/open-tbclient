package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class s extends HttpMessage {
    private long gQA;
    private String gQB;
    private long gQz;
    private String liveId;
    private String roomId;

    public s() {
        super(1021159);
    }

    public void fi(long j) {
        this.gQz = j;
    }

    public void fj(long j) {
        this.gQA = j;
    }

    public void Gd(String str) {
        this.gQB = str;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.gQz);
        addParam("red_packet_num", this.gQA);
        addParam("condition", this.gQB);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
