package com.baidu.tieba.ala.liveroom.messages;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private double aXy;
    private double aXz;
    private long brr;
    private String brs;
    private String hxE;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.brr = j;
    }

    public void b(double d, double d2) {
        this.aXy = d;
        this.aXz = d2;
    }

    public void Bc(String str) {
        this.brs = str;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void IC(String str) {
        this.hxE = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.brs = "";
        this.uk = "";
        this.mForumName = "";
        this.hxE = "";
    }

    public void setParams() {
        if (this.brr > 0) {
            addParam("live_id", this.brr);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.brs);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.aXy);
        addParam("lat", this.aXz);
        if (!TextUtils.isEmpty(this.hxE)) {
            addParam("fromishotswitch", this.hxE);
        }
    }
}
