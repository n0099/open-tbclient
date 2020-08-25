package com.baidu.tieba.ala.liveroom.messages;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class a extends HttpMessage {
    private String bev;
    private long bew;
    private double gEG;
    private double gEH;
    private String gEI;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.bew = j;
    }

    public void c(double d, double d2) {
        this.gEG = d;
        this.gEH = d2;
    }

    public void zl(String str) {
        this.bev = str;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void gS(String str) {
        this.roomId = str;
    }

    public void Gl(String str) {
        this.gEI = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.bev = "";
        this.uk = "";
        this.mForumName = "";
        this.gEI = "";
    }

    public void setParams() {
        if (this.bew > 0) {
            addParam("live_id", this.bew);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.bev);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.gEG);
        addParam("lat", this.gEH);
        if (!TextUtils.isEmpty(this.gEI)) {
            addParam("fromishotswitch", this.gEI);
        }
    }
}
