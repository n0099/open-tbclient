package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String aQf;
    private long aQg;
    private double fLC;
    private double fLD;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.aQg = j;
    }

    public void c(double d, double d2) {
        this.fLC = d;
        this.fLD = d2;
    }

    public void tR(String str) {
        this.aQf = str;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void eH(String str) {
        this.roomId = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.aQf = "";
        this.uk = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.aQg > 0) {
            addParam("live_id", this.aQg);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.aQf);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.fLC);
        addParam("lat", this.fLD);
    }
}
