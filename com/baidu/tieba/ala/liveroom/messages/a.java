package com.baidu.tieba.ala.liveroom.messages;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String blg;
    private long blh;
    private double gWI;
    private double gWJ;
    private String gWK;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.blh = j;
    }

    public void c(double d, double d2) {
        this.gWI = d;
        this.gWJ = d2;
    }

    public void At(String str) {
        this.blg = str;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void hx(String str) {
        this.roomId = str;
    }

    public void Hw(String str) {
        this.gWK = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.blg = "";
        this.uk = "";
        this.mForumName = "";
        this.gWK = "";
    }

    public void setParams() {
        if (this.blh > 0) {
            addParam("live_id", this.blh);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.blg);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.gWI);
        addParam("lat", this.gWJ);
        if (!TextUtils.isEmpty(this.gWK)) {
            addParam("fromishotswitch", this.gWK);
        }
    }
}
