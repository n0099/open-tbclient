package com.baidu.tieba.home;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class al implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1157a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.f1157a = akVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SearchActivity searchActivity;
        int i2;
        SearchActivity searchActivity2;
        SearchActivity searchActivity3;
        searchActivity = this.f1157a.f1156a;
        i2 = searchActivity.E;
        if (i2 == 0) {
            DatabaseService.q();
            searchActivity3 = this.f1157a.f1156a;
            searchActivity3.m();
            return;
        }
        DatabaseService.r();
        searchActivity2 = this.f1157a.f1156a;
        searchActivity2.o();
    }
}
