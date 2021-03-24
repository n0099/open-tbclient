package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes4.dex */
public class BawuTeamInfoReadCacheRequestMessage extends CustomMessage<Object> {
    public String cacheKey;

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
