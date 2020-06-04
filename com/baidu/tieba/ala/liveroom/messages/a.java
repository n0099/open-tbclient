package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String aWu;
    private long aWv;
    private double fZQ;
    private double fZR;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.aWv = j;
    }

    public void c(double d, double d2) {
        this.fZQ = d;
        this.fZR = d2;
    }

    public void vA(String str) {
        this.aWu = str;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void ft(String str) {
        this.roomId = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.aWu = "";
        this.uk = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.aWv > 0) {
            addParam("live_id", this.aWv);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.aWu);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.fZQ);
        addParam("lat", this.fZR);
    }
}
