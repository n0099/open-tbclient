package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class aa implements DialogInterface.OnClickListener {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.a = zVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SearchActivity searchActivity;
        int i2;
        SearchActivity searchActivity2;
        SearchActivity searchActivity3;
        searchActivity = this.a.a;
        i2 = searchActivity.B;
        if (i2 == 0) {
            com.baidu.tieba.d.k.q();
            searchActivity3 = this.a.a;
            searchActivity3.o();
            return;
        }
        com.baidu.tieba.d.k.r();
        searchActivity2 = this.a.a;
        searchActivity2.q();
    }
}
