package com.baidu.tieba.im.live;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.s;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class AccessTokenManager {
    private static AccessTokenManager _instance = new AccessTokenManager();
    private com.baidu.adp.framework.listener.b accessTokenListener = new a(this, MessageTypes.CMD_GET_ACCESS_TOKEN);

    public static AccessTokenManager getInstance() {
        return _instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public s<String> getTokenCache() {
        return BdCacheService.c().a("accessToken", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
    }

    private AccessTokenManager() {
        MessageManager.getInstance().registerListener(this.accessTokenListener);
    }

    public boolean getAccesssTokenInBackground(String str) {
        if (com.baidu.adp.lib.util.j.b(str)) {
            return false;
        }
        AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(str);
        if (parseBDUSS != null) {
            str = parseBDUSS.mBduss;
        }
        String a = getTokenCache().a(str);
        if (a != null) {
            onAccessTokenLoaded(str, a);
        } else {
            updateAccessTokenFromServer(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAccessTokenLoaded(String str, String str2) {
        AccessTokenUpdatedMessage accessTokenUpdatedMessage = new AccessTokenUpdatedMessage();
        accessTokenUpdatedMessage.setAccessToken(str2);
        accessTokenUpdatedMessage.setBduss(str);
        MessageManager.getInstance().dispatchResponsedMessageToUI(accessTokenUpdatedMessage);
    }

    private void updateAccessTokenFromServer(String str) {
        RequestGetAccessTokenMessage requestGetAccessTokenMessage = new RequestGetAccessTokenMessage();
        requestGetAccessTokenMessage.setBduss(str);
        MessageManager.getInstance().sendMessageFromBackground(requestGetAccessTokenMessage);
    }
}
