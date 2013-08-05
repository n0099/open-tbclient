package com.baidu.tieba.home;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ak implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aj f1123a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.f1123a = ajVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SearchActivity searchActivity;
        int i2;
        SearchActivity searchActivity2;
        SearchActivity searchActivity3;
        searchActivity = this.f1123a.f1122a;
        i2 = searchActivity.B;
        if (i2 == 0) {
            DatabaseService.s();
            searchActivity3 = this.f1123a.f1122a;
            searchActivity3.m();
            return;
        }
        DatabaseService.t();
        searchActivity2 = this.f1123a.f1122a;
        searchActivity2.o();
    }
}
