package com.baidu.tieba.frs.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o aPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aPq = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.view.b bVar;
        com.baidu.tbadk.coreExtra.view.b bVar2;
        bVar = this.aPq.adW;
        if (bVar != null) {
            bVar2 = this.aPq.adW;
            bVar2.wX();
        }
    }
}
