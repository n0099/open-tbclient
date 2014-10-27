package com.baidu.tieba.game.base;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public abstract class CachedHttpResponse extends HttpResponsedMessage {
    protected abstract String getCachedKey();

    public CachedHttpResponse(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        String cachedKey = getCachedKey();
        if (bArr != null && !StringUtils.isNull(cachedKey)) {
            com.baidu.tbadk.core.a.a.kS().bc("tb.game_center_list").b(cachedKey, bArr);
        }
    }
}
