package com.baidu.tieba.forumMember.tbtitle.model.req;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes17.dex */
public class GetLevelInfoReadCacheRequestMessage extends CustomMessage<Object> {
    private String cacheKey;

    public String getCacheKey() {
        return this.cacheKey;
    }

    public void setCacheKey(String str) {
        this.cacheKey = str;
    }

    public GetLevelInfoReadCacheRequestMessage() {
        super(CmdConfigCustom.CMD_GET_LEVEL_INFO_CACHE);
    }
}
