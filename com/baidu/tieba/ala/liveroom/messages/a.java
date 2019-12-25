package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes2.dex */
public class a extends HttpMessage {
    private String aru;
    private long arv;
    private double faE;
    private double faF;
    private String faG;
    private String mForumName;
    private String roomId;

    public void setLiveId(long j) {
        this.arv = j;
    }

    public void c(double d, double d2) {
        this.faE = d;
        this.faF = d2;
    }

    public void sk(String str) {
        this.aru = str;
    }

    public void yG(String str) {
        this.faG = str;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void dC(String str) {
        this.roomId = str;
    }

    public a() {
        super(1021005);
        this.roomId = "";
        this.aru = "";
        this.faG = "";
        this.mForumName = "";
    }

    public void setParams() {
        if (this.arv > 0) {
            addParam("live_id", this.arv);
        } else {
            addParam("live_id", "0");
        }
        addParam("room_id", this.roomId);
        addParam("from_type", this.aru);
        addParam(BdStatsConstant.StatsKey.UNAME, this.faG);
        addParam("forum_name", this.mForumName);
        addParam("lng", this.faE);
        addParam("lat", this.faF);
    }
}
