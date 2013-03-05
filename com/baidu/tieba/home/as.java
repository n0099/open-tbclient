package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class as implements DialogInterface.OnClickListener {
    final /* synthetic */ ar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.a = arVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SearchActivity searchActivity;
        int i2;
        SearchActivity searchActivity2;
        SearchActivity searchActivity3;
        searchActivity = this.a.a;
        i2 = searchActivity.D;
        if (i2 == 0) {
            com.baidu.tieba.c.k.o();
            searchActivity3 = this.a.a;
            searchActivity3.n();
            return;
        }
        com.baidu.tieba.c.k.p();
        searchActivity2 = this.a.a;
        searchActivity2.p();
    }
}
