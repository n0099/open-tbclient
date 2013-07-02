package com.baidu.tieba.home;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
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
        int i2;
        SearchActivity searchActivity2;
        SearchActivity searchActivity3;
        searchActivity = this.a.a;
        i2 = searchActivity.B;
        if (i2 == 0) {
            DatabaseService.s();
            searchActivity3 = this.a.a;
            searchActivity3.o();
            return;
        }
        DatabaseService.t();
        searchActivity2 = this.a.a;
        searchActivity2.q();
    }
}
