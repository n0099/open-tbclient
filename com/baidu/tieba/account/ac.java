package com.baidu.tieba.account;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1029a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(LoginActivity loginActivity) {
        this.f1029a = loginActivity;
    }

    @Override // com.baidu.tieba.account.r
    public void a(AccountData accountData) {
        AccountData accountData2;
        DatabaseService.a(accountData);
        accountData2 = this.f1029a.P;
        TiebaApplication.a(accountData2, this.f1029a.getBaseContext());
        this.f1029a.a();
    }
}
