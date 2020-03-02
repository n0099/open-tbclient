package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String awr;
    private long aws;
    private double fgD;
    private double fgE;
    private String fgF;
    private String mForumName;
    private String roomId;

    public void setLiveId(long j) {
        this.aws = j;
    }

    public void c(double d, double d2) {
        this.fgD = d;
        this.fgE = d2;
    }

    public void sE(String str) {
        this.awr = str;
    }

    public void zh(String str) {
        this.fgF = str;
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
        this.awr = "";
        this.fgF = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.aws > 0) {
            addParam("live_id", this.aws);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.awr);
        addParam(BdStatsConstant.StatsKey.UNAME, this.fgF);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.fgD);
        addParam("lat", this.fgE);
    }
}
