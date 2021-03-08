package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class s extends HttpMessage {
    private long gVg;
    private long gVh;
    private String gVi;
    private String liveId;
    private String roomId;

    public s() {
        super(1021159);
    }

    public void fo(long j) {
        this.gVg = j;
    }

    public void fp(long j) {
        this.gVh = j;
    }

    public void GM(String str) {
        this.gVi = str;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.gVg);
        addParam("red_packet_num", this.gVh);
        addParam("condition", this.gVi);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
