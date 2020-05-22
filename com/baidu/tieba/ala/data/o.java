package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class o extends HttpMessage {
    private long ftc;
    private long ftd;
    private String fte;
    private String liveId;
    private String roomId;

    public o() {
        super(1021159);
    }

    public void du(long j) {
        this.ftc = j;
    }

    public void dv(long j) {
        this.ftd = j;
    }

    public void BA(String str) {
        this.fte = str;
    }

    public void fs(String str) {
        this.liveId = str;
    }

    public void ft(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.ftc);
        addParam("red_packet_num", this.ftd);
        addParam("condition", this.fte);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
