package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class bd implements az {
    final /* synthetic */ ReLoginShareActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ReLoginShareActivity reLoginShareActivity) {
        this.a = reLoginShareActivity;
    }

    @Override // com.baidu.tieba.account.az
    public void a(String str) {
        String str2;
        ReLoginShareActivity reLoginShareActivity = this.a;
        str2 = this.a.f;
        reLoginShareActivity.a(0, str2, null);
    }

    @Override // com.baidu.tieba.account.az
    public void a(AccountData accountData) {
        boolean z;
        String str;
        z = this.a.j;
        if (z) {
            a(accountData.getAccount(), "");
            return;
        }
        if (accountData.getAccount() != null) {
            this.a.a(accountData);
        } else {
            ReLoginShareActivity reLoginShareActivity = this.a;
            str = this.a.f;
            reLoginShareActivity.a(2, str, accountData);
        }
        a.a().b("share_login_success");
    }

    @Override // com.baidu.tieba.account.az
    public void a(String str, String str2) {
        m.a().b(str);
        this.a.a(1, str2, null);
        a.a().b("share_login_failure");
    }
}
