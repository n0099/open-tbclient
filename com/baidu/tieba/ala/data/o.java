package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class o extends HttpMessage {
    private long ftn;
    private long fto;
    private String ftp;
    private String liveId;
    private String roomId;

    public o() {
        super(1021159);
    }

    public void du(long j) {
        this.ftn = j;
    }

    public void dv(long j) {
        this.fto = j;
    }

    public void BA(String str) {
        this.ftp = str;
    }

    public void fs(String str) {
        this.liveId = str;
    }

    public void ft(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.ftn);
        addParam("red_packet_num", this.fto);
        addParam("condition", this.ftp);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
