package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes2.dex */
public class a extends HttpMessage {
    private String asg;
    private long ash;
    private double fds;
    private double fdt;
    private String fdu;
    private String mForumName;
    private String roomId;

    public void setLiveId(long j) {
        this.ash = j;
    }

    public void c(double d, double d2) {
        this.fds = d;
        this.fdt = d2;
    }

    public void sn(String str) {
        this.asg = str;
    }

    public void yP(String str) {
        this.fdu = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void dE(String str) {
        this.roomId = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.asg = "";
        this.fdu = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.ash > 0) {
            addParam("live_id", this.ash);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.asg);
        addParam(BdStatsConstant.StatsKey.UNAME, this.fdu);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.fds);
        addParam("lat", this.fdt);
    }
}
