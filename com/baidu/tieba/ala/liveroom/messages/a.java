package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String aZb;
    private long aZc;
    private double grM;
    private double grN;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.aZc = j;
    }

    public void c(double d, double d2) {
        this.grM = d;
        this.grN = d2;
    }

    public void wX(String str) {
        this.aZb = str;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void fx(String str) {
        this.roomId = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.aZb = "";
        this.uk = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.aZc > 0) {
            addParam("live_id", this.aZc);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.aZb);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.grM);
        addParam("lat", this.grN);
    }
}
