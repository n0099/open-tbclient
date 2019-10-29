package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes6.dex */
public class a extends HttpMessage {
    private String ajL;
    private long ajM;
    private double elg;
    private double elh;
    private String eli;
    private String mForumName;
    private String roomId;

    public void setLiveId(long j) {
        this.ajM = j;
    }

    public void d(double d, double d2) {
        this.elg = d;
        this.elh = d2;
    }

    public void mX(String str) {
        this.ajL = str;
    }

    public void tR(String str) {
        this.eli = str;
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
        this.ajL = "";
        this.eli = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.ajM > 0) {
            addParam("live_id", this.ajM);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.ajL);
        addParam(BdStatsConstant.StatsKey.UNAME, this.eli);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.elg);
        addParam("lat", this.elh);
    }
}
