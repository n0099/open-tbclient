package com.baidu.tieba.forumMember.tbtitle.model.req;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes4.dex */
public class GetLevelInfoReadCacheRequestMessage extends CustomMessage<Object> {
    public String cacheKey;

    public GetLevelInfoReadCacheRequestMessage() {
        super(2003007);
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public void setCacheKey(String str) {
        this.cacheKey = str;
    }
}
