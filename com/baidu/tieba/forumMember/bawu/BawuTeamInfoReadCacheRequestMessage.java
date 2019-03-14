package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes5.dex */
public class BawuTeamInfoReadCacheRequestMessage extends CustomMessage<Object> {
    private String cacheKey;

    public BawuTeamInfoReadCacheRequestMessage() {
        super(2003005);
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public void setCacheKey(String str) {
        this.cacheKey = str;
    }
}
