package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements at {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.account.at
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
        new e(this, accountData).execute(new Void[0]);
    }

    @Override // com.baidu.tieba.account.at
    public void a(String str) {
        boolean z;
        Activity activity;
        int i;
        z = this.a.h;
        if (!z) {
            a aVar = this.a;
            activity = this.a.b;
            i = this.a.c;
            aVar.a(activity, i);
        }
    }
}
