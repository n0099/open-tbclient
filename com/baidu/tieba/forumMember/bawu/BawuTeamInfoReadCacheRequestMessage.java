package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes7.dex */
public class BawuTeamInfoReadCacheRequestMessage extends CustomMessage<Object> {
    private String cacheKey;

    public BawuTeamInfoReadCacheRequestMessage() {
        super(CmdConfigCustom.CMD_BAWU_TEAM_INFO_CACHE);
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public void setCacheKey(String str) {
        this.cacheKey = str;
    }
}
