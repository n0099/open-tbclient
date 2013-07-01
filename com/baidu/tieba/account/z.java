package com.baidu.tieba.account;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f685a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(LoginActivity loginActivity) {
        this.f685a = loginActivity;
    }

    @Override // com.baidu.tieba.account.o
    public void a(AccountData accountData) {
        AccountData accountData2;
        DatabaseService.a(accountData);
        accountData2 = this.f685a.T;
        TiebaApplication.b(accountData2);
        this.f685a.b();
    }
}
