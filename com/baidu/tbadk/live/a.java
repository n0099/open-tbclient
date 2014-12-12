package com.baidu.tbadk.live;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.core.account.AccountLoginHelper;
/* loaded from: classes.dex */
public class a {
    private static a aby = new a();
    private com.baidu.adp.framework.listener.e accessTokenListener = new b(this, 107201);

    public static a vV() {
        return aby;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public t<String> getTokenCache() {
        return BdCacheService.cS().a("accessToken", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
    }

    private a() {
        MessageManager.getInstance().registerListener(this.accessTokenListener);
    }

    public void asyncLoadAccessToken(String str) {
        if (com.baidu.adp.lib.util.l.fu()) {
            com.baidu.adp.lib.g.l.em().c(new c(this, str));
        } else {
            getAccesssTokenInBackground(str);
        }
    }

    public boolean getAccesssTokenInBackground(String str) {
        if (com.baidu.adp.lib.util.k.isEmpty(str)) {
            return false;
        }
        AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(str);
        if (parseBDUSS != null) {
            str = parseBDUSS.mBduss;
        }
        getTokenCache().a(str, new d(this));
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
