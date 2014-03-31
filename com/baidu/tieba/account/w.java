package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
final class w implements com.baidu.tbadk.core.a.u {
    final /* synthetic */ ReLoginShareActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ReLoginShareActivity reLoginShareActivity) {
        this.a = reLoginShareActivity;
    }

    @Override // com.baidu.tbadk.core.a.u
    public final void a(String str) {
        String str2;
        ReLoginShareActivity reLoginShareActivity = this.a;
        str2 = this.a.f;
        reLoginShareActivity.a(0, str2, null);
    }

    @Override // com.baidu.tbadk.core.a.u
    public final void a(AccountData accountData) {
        boolean z;
        String str;
        z = this.a.j;
        if (z) {
            a(accountData.getAccount(), "");
            return;
        }
        if (accountData.getAccount() != null) {
            ReLoginShareActivity.a(this.a, accountData);
        } else {
            ReLoginShareActivity reLoginShareActivity = this.a;
            str = this.a.f;
            reLoginShareActivity.a(2, str, accountData);
        }
        com.baidu.tbadk.core.a.a.a();
        com.baidu.tbadk.core.a.a.b("share_login_success");
    }

    @Override // com.baidu.tbadk.core.a.u
    public final void a(String str, String str2) {
        com.baidu.tbadk.core.a.l.a().b(str);
        this.a.a(1, str2, null);
        com.baidu.tbadk.core.a.a.a();
        com.baidu.tbadk.core.a.a.b("share_login_failure");
    }
}
