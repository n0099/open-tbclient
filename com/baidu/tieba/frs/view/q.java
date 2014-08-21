package com.baidu.tieba.frs.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar) {
        this.a = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.c cVar;
        com.baidu.tbadk.coreExtra.view.c cVar2;
        cVar = this.a.au;
        if (cVar != null) {
            cVar2 = this.a.au;
            cVar2.a();
        }
    }
}
