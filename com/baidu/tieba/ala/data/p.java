package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class p extends HttpMessage {
    private long fVo;
    private long fVp;
    private String fVq;
    private String liveId;
    private String roomId;

    public p() {
        super(1021159);
    }

    public void dW(long j) {
        this.fVo = j;
    }

    public void dX(long j) {
        this.fVp = j;
    }

    public void Fg(String str) {
        this.fVq = str;
    }

    public void gc(String str) {
        this.liveId = str;
    }

    public void gT(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.fVo);
        addParam("red_packet_num", this.fVp);
        addParam("condition", this.fVq);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
