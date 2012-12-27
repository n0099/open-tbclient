package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ak implements DialogInterface.OnClickListener {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.a = ajVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        SearchActivity searchActivity;
        com.baidu.tieba.c.k.n();
        searchActivity = this.a.a;
        searchActivity.k();
    }
}
