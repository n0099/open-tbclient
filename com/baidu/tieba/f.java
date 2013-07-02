package com.baidu.tieba;

import android.app.Activity;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.account.ReLoginActivity;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements AccountProxy.TokenCallback {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;
    private final /* synthetic */ boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Activity activity, String str, int i, boolean z) {
        this.a = activity;
        this.b = str;
        this.c = i;
        this.d = z;
    }

    @Override // com.baidu.account.AccountProxy.TokenCallback
    public void callBack(String str) {
        com.baidu.tieba.util.z.e("BaiduAccountProxy", "getAccountData", "token = " + str);
        if (str != null) {
            BaiduAccount baiduAccount = BaiduAccount.get(this.a);
            AccountData accountData = new AccountData();
            accountData.setAccount(baiduAccount.getCurrentAccount());
            accountData.setBDUSS(str);
            accountData.setIsActive(1);
            ReLoginActivity.a(this.a, this.b, this.c, this.d, accountData);
        } else if ((this.a instanceof GuideActivity) || (this.a instanceof LogoActivity)) {
            this.a.finish();
        }
    }
}
