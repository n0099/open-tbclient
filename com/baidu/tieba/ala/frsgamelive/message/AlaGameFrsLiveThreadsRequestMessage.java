package com.baidu.tieba.ala.frsgamelive.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes2.dex */
public class AlaGameFrsLiveThreadsRequestMessage extends HttpMessage {
    private String forumGameLabel;
    private String forumId;
    private int pn;
    private int ps;
    private int sortType;
    private int tabType;

    public AlaGameFrsLiveThreadsRequestMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME);
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

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    public void setTabType(int i) {
        this.tabType = i;
    }

    public int getTabType() {
        return this.tabType;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public void setHttpParams() {
        addParam("forum_id", this.forumId);
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("ps", this.ps);
        addParam("forum_game_label", this.forumGameLabel);
        addParam("tab_type", this.tabType);
        addParam(PbActivityConfig.KEY_SORTTYPE, this.sortType);
    }
}
