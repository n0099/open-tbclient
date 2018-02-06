package com.baidu.tieba.forumMember.tbtitle.model.req;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes3.dex */
public class GetLevelInfoReadCacheRequestMessage extends CustomMessage<Object> {
    private String cacheKey;

    public String getCacheKey() {
        return this.cacheKey;
    }

    public void setCacheKey(String str) {
        this.cacheKey = str;
    }

    public GetLevelInfoReadCacheRequestMessage() {
        super(2003007);
    }
}
