package com.baidu.tieba.account;

import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements AccountProxy.TokenCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1033a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ReLoginActivity reLoginActivity) {
        this.f1033a = reLoginActivity;
    }

    @Override // com.baidu.account.AccountProxy.TokenCallback
    public void callBack(String str) {
        bg.e("BaiduAccountProxy", "getAccountData", "token = " + str);
        if (str != null) {
            this.f1033a.a(BaiduAccount.get(this.f1033a).getCurrentAccount(), str);
            return;
        }
        this.f1033a.finish();
    }
}
