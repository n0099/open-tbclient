package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class p extends HttpMessage {
    private long fVk;
    private long fVl;
    private String fVm;
    private String liveId;
    private String roomId;

    public p() {
        super(1021159);
    }

    public void dW(long j) {
        this.fVk = j;
    }

    public void dX(long j) {
        this.fVl = j;
    }

    public void Ff(String str) {
        this.fVm = str;
    }

    public void gb(String str) {
        this.liveId = str;
    }

    public void gS(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.fVk);
        addParam("red_packet_num", this.fVl);
        addParam("condition", this.fVm);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
