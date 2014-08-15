package com.baidu.tieba.im.live;

import com.baidu.adp.lib.cache.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements u<String> {
    final /* synthetic */ AccessTokenManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AccessTokenManager accessTokenManager) {
        this.a = accessTokenManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    public void a(String str, String str2) {
        if (str2 != null) {
            this.a.onAccessTokenLoaded(str, str2);
        } else {
            this.a.updateAccessTokenFromServer(str);
        }
    }
}
