package com.baidu.tieba.game.base;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public abstract class CachedSocketResponse extends SocketResponsedMessage {
    protected abstract String getCacheKey();

    public CachedSocketResponse(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        String cacheKey = getCacheKey();
        if (bArr != null && !StringUtils.isNull(cacheKey)) {
            com.baidu.tbadk.core.a.a.kS().bc("tb.game_center_list").b(cacheKey, bArr);
        }
    }
}
