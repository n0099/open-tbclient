package com.baidu.tieba.account;

import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements AccountProxy.TokenCallback {
    final /* synthetic */ ReLoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ReLoginActivity reLoginActivity) {
        this.a = reLoginActivity;
    }

    @Override // com.baidu.account.AccountProxy.TokenCallback
    public void callBack(String str) {
        com.baidu.tieba.c.ag.e("BaiduAccountProxy", "getAccountData", "token = " + str);
        if (str != null) {
            this.a.a(BaiduAccount.get(this.a).getCurrentAccount(), str);
            return;
        }
        this.a.finish();
    }
}
