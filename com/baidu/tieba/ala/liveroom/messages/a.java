package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String aZd;
    private long aZe;
    private double gmO;
    private double gmP;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.aZe = j;
    }

    public void c(double d, double d2) {
        this.gmO = d;
        this.gmP = d2;
    }

    public void vQ(String str) {
        this.aZd = str;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void fy(String str) {
        this.roomId = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.aZd = "";
        this.uk = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.aZe > 0) {
            addParam("live_id", this.aZe);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.aZd);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.gmO);
        addParam("lat", this.gmP);
    }
}
