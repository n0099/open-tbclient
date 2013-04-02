package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ap implements DialogInterface.OnClickListener {
    final /* synthetic */ ao a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.a = aoVar;
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
            com.baidu.tieba.c.k.p();
            searchActivity3 = this.a.a;
            searchActivity3.n();
            return;
        }
        com.baidu.tieba.c.k.q();
        searchActivity2 = this.a.a;
        searchActivity2.p();
    }
}
