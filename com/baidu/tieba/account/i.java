package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements be {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.account.be
    public void a(String str) {
    }

    @Override // com.baidu.tieba.account.be
    public void a(AccountData accountData) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        int i;
        activity = this.a.b;
        TiebaApplication.a(accountData, activity);
        l.a().b();
        activity2 = this.a.b;
        if (activity2 != null) {
            activity3 = this.a.b;
            i = this.a.c;
            MainTabActivity.b(activity3, i);
        }
        new j(this, accountData).execute(new Void[0]);
    }

    @Override // com.baidu.tieba.account.be
    public void a(String str, String str2) {
        AccountData c;
        int i;
        ArrayList arrayList;
        as asVar;
        c = this.a.c(str);
        if (c == null || com.baidu.tieba.util.bc.c(c.getPassword())) {
            i = this.a.f;
            arrayList = this.a.e;
            if (i < arrayList.size()) {
                this.a.b();
                return;
            } else {
                this.a.c();
                return;
            }
        }
        String account = c.getAccount();
        String password = c.getPassword();
        asVar = this.a.i;
        ar.a(account, password, asVar);
    }
}
