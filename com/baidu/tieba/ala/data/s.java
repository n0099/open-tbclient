package com.baidu.tieba.ala.data;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class s extends HttpMessage {
    private long gJs;
    private long gJt;
    private String gJu;
    private String liveId;
    private String roomId;

    public s() {
        super(1021159);
    }

    public void fi(long j) {
        this.gJs = j;
    }

    public void fj(long j) {
        this.gJt = j;
    }

    public void Hp(String str) {
        this.gJu = str;
    }

    public void setLiveId(String str) {
        this.liveId = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setParams() {
        addParam("red_packet_balance", this.gJs);
        addParam("red_packet_num", this.gJt);
        addParam("condition", this.gJu);
        addParam("live_id", this.liveId);
        addParam("room_id", this.roomId);
    }
}
