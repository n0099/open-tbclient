package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String aws;
    private long awt;
    private double fgQ;
    private double fgR;
    private String fgS;
    private String mForumName;
    private String roomId;

    public void setLiveId(long j) {
        this.awt = j;
    }

    public void c(double d, double d2) {
        this.fgQ = d;
        this.fgR = d2;
    }

    public void sE(String str) {
        this.aws = str;
    }

    public void zi(String str) {
        this.fgS = str;
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
        this.aws = "";
        this.fgS = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.awt > 0) {
            addParam("live_id", this.awt);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.aws);
        addParam(BdStatsConstant.StatsKey.UNAME, this.fgS);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.fgQ);
        addParam("lat", this.fgR);
    }
}
