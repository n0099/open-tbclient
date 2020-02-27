package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String awq;
    private long awr;
    private double fgC;
    private double fgD;
    private String fgE;
    private String mForumName;
    private String roomId;

    public void setLiveId(long j) {
        this.awr = j;
    }

    public void c(double d, double d2) {
        this.fgC = d;
        this.fgD = d2;
    }

    public void sE(String str) {
        this.awq = str;
    }

    public void zh(String str) {
        this.fgE = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void dP(String str) {
        this.roomId = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.awq = "";
        this.fgE = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.awr > 0) {
            addParam("live_id", this.awr);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.awq);
        addParam(BdStatsConstant.StatsKey.UNAME, this.fgE);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.fgC);
        addParam("lat", this.fgD);
    }
}
