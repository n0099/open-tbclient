package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes6.dex */
public class a extends HttpMessage {
    private String ajt;
    private long aju;
    private double ekp;
    private double ekq;
    private String ekr;
    private String mForumName;
    private String roomId;

    public void setLiveId(long j) {
        this.aju = j;
    }

    public void d(double d, double d2) {
        this.ekp = d;
        this.ekq = d2;
    }

    public void mX(String str) {
        this.ajt = str;
    }

    public void tR(String str) {
        this.ekr = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void cL(String str) {
        this.roomId = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.ajt = "";
        this.ekr = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.aju > 0) {
            addParam("live_id", this.aju);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.ajt);
        addParam(BdStatsConstant.StatsKey.UNAME, this.ekr);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.ekp);
        addParam("lat", this.ekq);
    }
}
