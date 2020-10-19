package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class q extends HttpMessage {
    private long gkT;
    private long gkU;
    private String gkV;
    private String liveId;
    private String roomId;

    public q() {
        super(1021159);
    }

    public void eh(long j) {
        this.gkT = j;
    }

    public void ei(long j) {
        this.gkU = j;
    }

    public void Gp(String str) {
        this.gkV = str;
    }

    public void gx(String str) {
        this.liveId = str;
    }

    public void hx(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.gkT);
        addParam("red_packet_num", this.gkU);
        addParam("condition", this.gkV);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
