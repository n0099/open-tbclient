package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String aQl;
    private long aQm;
    private double fLH;
    private double fLI;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.aQm = j;
    }

    public void c(double d, double d2) {
        this.fLH = d;
        this.fLI = d2;
    }

    public void tU(String str) {
        this.aQl = str;
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
        this.aQl = "";
        this.uk = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.aQm > 0) {
            addParam("live_id", this.aQm);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.aQl);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.fLH);
        addParam("lat", this.fLI);
    }
}
