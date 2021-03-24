package com.baidu.tieba.ala.frsgamelive.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class AlaGameFrsLiveThreadsRequestMessage extends HttpMessage {
    public String forumGameLabel;
    public String forumId;
    public int pn;
    public int ps;
    public int sortType;
    public int tabType;

    public AlaGameFrsLiveThreadsRequestMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME);
    }

    public int getPn() {
        return this.pn;
    }

    public int getTabType() {
        return this.tabType;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setHttpParams() {
        addParam("forum_id", this.forumId);
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("ps", this.ps);
        addParam("forum_game_label", this.forumGameLabel);
        addParam("tab_type", this.tabType);
        addParam("sort_type", this.sortType);
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void setPs(int i) {
        this.ps = i;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void setTabType(int i) {
        this.tabType = i;
    }
}
