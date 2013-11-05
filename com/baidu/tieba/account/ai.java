package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1021a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ReLoginActivity reLoginActivity) {
        this.f1021a = reLoginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountData accountData;
        String str;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        accountData = this.f1021a.m;
        if (accountData != null) {
            accountData2 = this.f1021a.m;
            if (accountData2.getAccount() != null) {
                accountData3 = this.f1021a.m;
                if (!accountData3.getAccount().equals("BaiduUser")) {
                    ReLoginActivity reLoginActivity = this.f1021a;
                    accountData4 = this.f1021a.m;
                    reLoginActivity.a(accountData4);
                    return;
                }
            }
            this.f1021a.f();
            return;
        }
        ReLoginActivity reLoginActivity2 = this.f1021a;
        str = this.f1021a.p;
        reLoginActivity2.a(1, str);
    }
}
