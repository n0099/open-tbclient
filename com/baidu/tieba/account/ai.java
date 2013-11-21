package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1035a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ReLoginActivity reLoginActivity) {
        this.f1035a = reLoginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountData accountData;
        String str;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        accountData = this.f1035a.i;
        if (accountData != null) {
            accountData2 = this.f1035a.i;
            if (accountData2.getAccount() != null) {
                accountData3 = this.f1035a.i;
                if (!accountData3.getAccount().equals("BaiduUser")) {
                    ReLoginActivity reLoginActivity = this.f1035a;
                    accountData4 = this.f1035a.i;
                    reLoginActivity.a(accountData4);
                    return;
                }
            }
            this.f1035a.e();
            return;
        }
        ReLoginActivity reLoginActivity2 = this.f1035a;
        str = this.f1035a.l;
        reLoginActivity2.a(1, str);
    }
}
