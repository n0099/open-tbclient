package com.baidu.tieba.account;

import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements AccountProxy.TokenCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f877a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ReLoginActivity reLoginActivity) {
        this.f877a = reLoginActivity;
    }

    @Override // com.baidu.account.AccountProxy.TokenCallback
    public void callBack(String str) {
        com.baidu.tieba.util.aq.e("BaiduAccountProxy", "getAccountData", "token = " + str);
        if (str != null) {
            this.f877a.a(BaiduAccount.get(this.f877a).getCurrentAccount(), str);
            return;
        }
        this.f877a.finish();
    }
}
