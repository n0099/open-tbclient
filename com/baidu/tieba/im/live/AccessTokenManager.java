package com.baidu.tieba.im.live;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.core.account.AccountLoginHelper;
/* loaded from: classes.dex */
public class AccessTokenManager {
    private static AccessTokenManager _instance = new AccessTokenManager();
    private com.baidu.adp.framework.listener.d accessTokenListener = new a(this, 107201);

    public static AccessTokenManager getInstance() {
        return _instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public t<String> getTokenCache() {
        return BdCacheService.c().a("accessToken", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
    }

    private AccessTokenManager() {
        MessageManager.getInstance().registerListener(this.accessTokenListener);
    }

    public void asyncLoadAccessToken(String str) {
        if (com.baidu.adp.lib.util.j.b()) {
            com.baidu.adp.lib.e.e.a().a(new b(this, str));
        } else {
            getAccesssTokenInBackground(str);
        }
    }

    public boolean getAccesssTokenInBackground(String str) {
        if (com.baidu.adp.lib.util.i.c(str)) {
            return false;
        }
        AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(str);
        if (parseBDUSS != null) {
            str = parseBDUSS.mBduss;
        }
        getTokenCache().a(str, new c(this));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAccessTokenLoaded(String str, String str2) {
        AccessTokenUpdatedMessage accessTokenUpdatedMessage = new AccessTokenUpdatedMessage();
        accessTokenUpdatedMessage.setAccessToken(str2);
        accessTokenUpdatedMessage.setBduss(str);
        MessageManager.getInstance().dispatchResponsedMessageToUI(accessTokenUpdatedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAccessTokenFromServer(String str) {
        RequestGetAccessTokenMessage requestGetAccessTokenMessage = new RequestGetAccessTokenMessage();
        requestGetAccessTokenMessage.setBduss(str);
        MessageManager.getInstance().sendMessageFromBackground(requestGetAccessTokenMessage);
    }
}
