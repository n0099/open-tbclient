package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1032a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ReLoginActivity reLoginActivity) {
        this.f1032a = reLoginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountData accountData;
        String str;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        accountData = this.f1032a.i;
        if (accountData != null) {
            accountData2 = this.f1032a.i;
            if (accountData2.getAccount() != null) {
                accountData3 = this.f1032a.i;
                if (!accountData3.getAccount().equals("BaiduUser")) {
                    ReLoginActivity reLoginActivity = this.f1032a;
                    accountData4 = this.f1032a.i;
                    reLoginActivity.a(accountData4);
                    return;
                }
            }
            this.f1032a.e();
            return;
        }
        ReLoginActivity reLoginActivity2 = this.f1032a;
        str = this.f1032a.l;
        reLoginActivity2.a(1, str);
    }
}
