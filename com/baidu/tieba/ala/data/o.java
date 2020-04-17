package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class o extends HttpMessage {
    private long ffs;
    private long fft;
    private String ffu;
    private String liveId;
    private String roomId;

    public o() {
        super(1021159);
    }

    public void ds(long j) {
        this.ffs = j;
    }

    public void dt(long j) {
        this.fft = j;
    }

    public void zQ(String str) {
        this.ffu = str;
    }

    public void eG(String str) {
        this.liveId = str;
    }

    public void eH(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.ffs);
        addParam("red_packet_num", this.fft);
        addParam("condition", this.ffu);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
