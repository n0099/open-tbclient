package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f644a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ReLoginActivity reLoginActivity) {
        this.f644a = reLoginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountData accountData;
        String str;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        accountData = this.f644a.m;
        if (accountData != null) {
            accountData2 = this.f644a.m;
            if (accountData2.getAccount() != null) {
                accountData3 = this.f644a.m;
                if (!accountData3.getAccount().equals("BaiduUser")) {
                    ReLoginActivity reLoginActivity = this.f644a;
                    accountData4 = this.f644a.m;
                    reLoginActivity.a(accountData4);
                    return;
                }
            }
            this.f644a.n();
            return;
        }
        ReLoginActivity reLoginActivity2 = this.f644a;
        str = this.f644a.p;
        reLoginActivity2.a(1, str);
    }
}
