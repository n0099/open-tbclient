package com.baidu.tieba.home;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class x implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f1231a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.f1231a = wVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SearchActivity searchActivity;
        int i2;
        SearchActivity searchActivity2;
        SearchActivity searchActivity3;
        searchActivity = this.f1231a.f1230a;
        i2 = searchActivity.E;
        if (i2 == 0) {
            DatabaseService.q();
            searchActivity3 = this.f1231a.f1230a;
            searchActivity3.n();
            return;
        }
        DatabaseService.r();
        searchActivity2 = this.f1231a.f1230a;
        searchActivity2.p();
    }
}
