package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements az {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.account.az
    public final void a(String str) {
        k kVar;
        k unused;
        kVar = this.a.d;
        if (kVar != null) {
            unused = this.a.d;
        }
    }

    @Override // com.baidu.tieba.account.az
    public final void a(AccountData accountData) {
        Activity activity;
        Activity activity2;
        k kVar;
        k kVar2;
        activity = this.a.b;
        TiebaApplication.a(accountData, activity);
        activity2 = this.a.b;
        if (activity2 != null) {
            TiebaApplication.g();
            TiebaApplication.u();
            com.baidu.tieba.mention.v.a().j();
            com.baidu.tieba.mention.v.a().h();
            kVar = this.a.d;
            if (kVar != null) {
                kVar2 = this.a.d;
                kVar2.a();
            }
        }
        new i(this, accountData).execute(new Void[0]);
    }

    @Override // com.baidu.tieba.account.az
    public final void a(String str, String str2) {
        int i;
        ArrayList arrayList;
        at atVar;
        AccountData a = a.a(this.a, str);
        if (a == null || com.baidu.tieba.util.bs.c(a.getPassword())) {
            i = this.a.g;
            arrayList = this.a.f;
            if (i >= arrayList.size()) {
                a.k(this.a);
                return;
            } else {
                this.a.b();
                return;
            }
        }
        String account = a.getAccount();
        String password = a.getPassword();
        atVar = this.a.j;
        as.a(account, password, atVar);
    }
}
