package com.baidu.tieba.ala.frsgamelive.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class AlaFrsStoryLiveGatherRequestMessage extends HttpMessage {
    public String forumId;
    public int needRecommend;
    public int pn;
    public int ps;
    public int sortType;

    public AlaFrsStoryLiveGatherRequestMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER);
    }

    public int getPn() {
        return this.pn;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setHttpParams() {
        addParam("forum_id", this.forumId);
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("ps", this.ps);
        addParam("sort_type", this.sortType);
        addParam("need_recommend", this.needRecommend);
    }

    public void setNeedRecommend(int i2) {
        this.needRecommend = i2;
    }

    public void setPn(int i2) {
        this.pn = i2;
    }

    public void setPs(int i2) {
        this.ps = i2;
    }

    public void setSortType(int i2) {
        this.sortType = i2;
    }
}
