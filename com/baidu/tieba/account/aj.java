package com.baidu.tieba.account;

import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements AccountProxy.TokenCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1022a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ReLoginActivity reLoginActivity) {
        this.f1022a = reLoginActivity;
    }

    @Override // com.baidu.account.AccountProxy.TokenCallback
    public void callBack(String str) {
        be.e("BaiduAccountProxy", "getAccountData", "token = " + str);
        if (str != null) {
            this.f1022a.a(BaiduAccount.get(this.f1022a).getCurrentAccount(), str);
            return;
        }
        this.f1022a.finish();
    }
}
