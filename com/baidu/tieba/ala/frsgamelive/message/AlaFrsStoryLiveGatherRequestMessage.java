package com.baidu.tieba.ala.frsgamelive.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes10.dex */
public class AlaFrsStoryLiveGatherRequestMessage extends HttpMessage {
    private String forumId;
    private int needRecommend;
    private int pn;
    private int ps;
    private int sortType;

    public AlaFrsStoryLiveGatherRequestMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER);
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public int getPn() {
        return this.pn;
    }

    public void setPs(int i) {
        this.ps = i;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void setNeedRecommend(int i) {
        this.needRecommend = i;
    }

    public void setHttpParams() {
        addParam("forum_id", this.forumId);
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("ps", this.ps);
        addParam(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        addParam("need_recommend", this.needRecommend);
    }
}
