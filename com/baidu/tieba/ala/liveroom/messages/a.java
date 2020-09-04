package com.baidu.tieba.ala.liveroom.messages;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class a extends HttpMessage {
    private String bex;
    private long bey;
    private double gEK;
    private double gEL;
    private String gEM;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.bey = j;
    }

    public void c(double d, double d2) {
        this.gEK = d;
        this.gEL = d2;
    }

    public void zm(String str) {
        this.bex = str;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void gT(String str) {
        this.roomId = str;
    }

    public void Gm(String str) {
        this.gEM = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.bex = "";
        this.uk = "";
        this.mForumName = "";
        this.gEM = "";
    }

    public void setParams() {
        if (this.bey > 0) {
            addParam("live_id", this.bey);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.bex);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.gEK);
        addParam("lat", this.gEL);
        if (!TextUtils.isEmpty(this.gEM)) {
            addParam("fromishotswitch", this.gEM);
        }
    }
}
