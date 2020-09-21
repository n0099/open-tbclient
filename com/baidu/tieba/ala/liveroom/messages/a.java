package com.baidu.tieba.ala.liveroom.messages;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String bhq;
    private long bhr;
    private double gIi;
    private double gIj;
    private String gIk;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.bhr = j;
    }

    public void c(double d, double d2) {
        this.gIi = d;
        this.gIj = d2;
    }

    public void zH(String str) {
        this.bhq = str;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void hg(String str) {
        this.roomId = str;
    }

    public void GK(String str) {
        this.gIk = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.bhq = "";
        this.uk = "";
        this.mForumName = "";
        this.gIk = "";
    }

    public void setParams() {
        if (this.bhr > 0) {
            addParam("live_id", this.bhr);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.bhq);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.gIi);
        addParam("lat", this.gIj);
        if (!TextUtils.isEmpty(this.gIk)) {
            addParam("fromishotswitch", this.gIk);
        }
    }
}
