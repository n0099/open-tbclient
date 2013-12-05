package com.baidu.tieba;

import android.app.Activity;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.account.ReLoginActivity;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements AccountProxy.TokenCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f1511a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Activity activity, int i, int i2, boolean z) {
        this.f1511a = activity;
        this.b = i;
        this.c = i2;
        this.d = z;
    }

    @Override // com.baidu.account.AccountProxy.TokenCallback
    public void callBack(String str) {
        com.baidu.tieba.util.bd.e("BaiduAccountProxy", "getAccountData", "token = " + str);
        if (str != null) {
            BaiduAccount baiduAccount = BaiduAccount.get(this.f1511a);
            AccountData accountData = new AccountData();
            accountData.setAccount(baiduAccount.getCurrentAccount());
            accountData.setPortrait(null);
            accountData.setBDUSS(str);
            accountData.setIsActive(1);
            ReLoginActivity.a(this.f1511a, this.b, this.c, this.d, accountData);
        } else if ((this.f1511a instanceof GuideActivity) || (this.f1511a instanceof LogoActivity)) {
            this.f1511a.finish();
        }
    }
}
