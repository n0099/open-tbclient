package com.baidu.tbadk.live;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.core.account.AccountLoginHelper;
/* loaded from: classes.dex */
public class a {
    private static a Vq = new a();
    private com.baidu.adp.framework.listener.e Vr = new b(this, 107201);

    public static a ss() {
        return Vq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public t<String> st() {
        return BdCacheService.cr().a("accessToken", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.NO_EVICT, 1);
    }

    private a() {
        MessageManager.getInstance().registerListener(this.Vr);
    }

    public void dy(String str) {
        if (com.baidu.adp.lib.util.m.fu()) {
            com.baidu.adp.lib.g.k.el().b(new c(this, str));
        } else {
            dz(str);
        }
    }

    public boolean dz(String str) {
        if (com.baidu.adp.lib.util.l.aA(str)) {
            return false;
        }
        AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(str);
        if (parseBDUSS != null) {
            str = parseBDUSS.mBduss;
        }
        st().a(str, new d(this));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X(String str, String str2) {
        AccessTokenUpdatedMessage accessTokenUpdatedMessage = new AccessTokenUpdatedMessage();
        accessTokenUpdatedMessage.setAccessToken(str2);
        accessTokenUpdatedMessage.setBduss(str);
        MessageManager.getInstance().dispatchResponsedMessageToUI(accessTokenUpdatedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(String str) {
        RequestGetAccessTokenMessage requestGetAccessTokenMessage = new RequestGetAccessTokenMessage();
        requestGetAccessTokenMessage.setBduss(str);
        MessageManager.getInstance().sendMessageFromBackground(requestGetAccessTokenMessage);
    }
}
