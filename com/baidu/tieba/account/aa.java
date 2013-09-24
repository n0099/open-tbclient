package com.baidu.tieba.account;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f884a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(LoginActivity loginActivity) {
        this.f884a = loginActivity;
    }

    @Override // com.baidu.tieba.account.p
    public void a(AccountData accountData) {
        AccountData accountData2;
        DatabaseService.a(accountData);
        accountData2 = this.f884a.T;
        TiebaApplication.a(accountData2, this.f884a.getBaseContext());
        this.f884a.b();
    }
}
