package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements az {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.account.az
    public void a(String str) {
        k kVar;
        k kVar2;
        kVar = this.a.d;
        if (kVar != null) {
            kVar2 = this.a.d;
            kVar2.a(str);
        }
    }

    @Override // com.baidu.tieba.account.az
    public void a(AccountData accountData) {
        Activity activity;
        Activity activity2;
        k kVar;
        k kVar2;
        activity = this.a.b;
        TiebaApplication.a(accountData, activity);
        activity2 = this.a.b;
        if (activity2 != null) {
            TiebaApplication.g().z();
            com.baidu.tieba.mention.v.a().l();
            com.baidu.tieba.mention.v.a().j();
            kVar = this.a.d;
            if (kVar != null) {
                kVar2 = this.a.d;
                kVar2.a();
            }
        }
        new i(this, accountData).execute(new Void[0]);
    }

    @Override // com.baidu.tieba.account.az
    public void a(String str, String str2) {
        AccountData c;
        int i;
        ArrayList arrayList;
        at atVar;
        c = this.a.c(str);
        if (c == null || com.baidu.tieba.util.bs.c(c.getPassword())) {
            i = this.a.g;
            arrayList = this.a.f;
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
        atVar = this.a.j;
        as.a(account, password, atVar);
    }
}
