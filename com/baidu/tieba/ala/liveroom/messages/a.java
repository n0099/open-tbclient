package com.baidu.tieba.ala.liveroom.messages;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    private double aUq;
    private double aUr;
    private long brk;
    private String brl;
    private String hEW;
    private String mForumName;
    private String roomId;
    private String uk;

    public void setLiveId(long j) {
        this.brk = j;
    }

    public void b(double d, double d2) {
        this.aUq = d;
        this.aUr = d2;
    }

    public void zP(String str) {
        this.brl = str;
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

    public void Hs(String str) {
        this.hEW = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.brl = "";
        this.uk = "";
        this.mForumName = "";
        this.hEW = "";
    }

    public void setParams() {
        if (this.brk > 0) {
            addParam("live_id", this.brk);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.brl);
        addParam("uk", this.uk);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.aUq);
        addParam("lat", this.aUr);
        if (!TextUtils.isEmpty(this.hEW)) {
            addParam("fromishotswitch", this.hEW);
        }
    }
}
