package com.baidu.tieba.im.live;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ AccessTokenManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AccessTokenManager accessTokenManager, int i) {
        super(i);
        this.a = accessTokenManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        t tokenCache;
        if (socketResponsedMessage instanceof ResponseGetAccessTokenMessage) {
            ResponseGetAccessTokenMessage responseGetAccessTokenMessage = (ResponseGetAccessTokenMessage) socketResponsedMessage;
            RequestGetAccessTokenMessage requestGetAccessTokenMessage = (RequestGetAccessTokenMessage) responseGetAccessTokenMessage.getOrginalMessage();
            this.a.onAccessTokenLoaded(requestGetAccessTokenMessage.getBduss(), responseGetAccessTokenMessage.getAccessToken());
            if (!responseGetAccessTokenMessage.hasError() && responseGetAccessTokenMessage.getAccessToken() != null) {
                long min = Math.min(responseGetAccessTokenMessage.getLeftExpiredTimeInSeconds() * 1000, 432000000L);
                if (min <= 1000) {
                    min = 86400000;
                }
                tokenCache = this.a.getTokenCache();
                tokenCache.b(requestGetAccessTokenMessage.getBduss(), responseGetAccessTokenMessage.getAccessToken(), min);
            }
        }
    }
}
