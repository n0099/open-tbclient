package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes2.dex */
public class o extends HttpMessage {
    private long ewe;
    private long ewf;
    private String ewg;
    private String liveId;
    private String roomId;

    public o() {
        super(1021159);
    }

    public void cH(long j) {
        this.ewe = j;
    }

    public void cI(long j) {
        this.ewf = j;
    }

    public void xM(String str) {
        this.ewg = str;
    }

    public void dD(String str) {
        this.liveId = str;
    }

    public void dE(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.ewe);
        addParam("red_packet_num", this.ewf);
        addParam("condition", this.ewg);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
