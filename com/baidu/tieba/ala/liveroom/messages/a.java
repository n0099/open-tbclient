package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String awC;
    private long awD;
    private double fhp;
    private double fhq;
    private String fhr;
    private String mForumName;
    private String roomId;

    public void setLiveId(long j) {
        this.awD = j;
    }

    public void c(double d, double d2) {
        this.fhp = d;
        this.fhq = d2;
    }

    public void sE(String str) {
        this.awC = str;
    }

    public void zj(String str) {
        this.fhr = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void dO(String str) {
        this.roomId = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.awC = "";
        this.fhr = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.awD > 0) {
            addParam("live_id", this.awD);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.awC);
        addParam(BdStatsConstant.StatsKey.UNAME, this.fhr);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.fhp);
        addParam("lat", this.fhq);
    }
}
