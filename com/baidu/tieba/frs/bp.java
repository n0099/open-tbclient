package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ bf aMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bf bfVar) {
        this.aMc = bfVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        eVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.aMc.aKd;
            com.baidu.tbadk.core.util.az.d(frsActivity2.getPageContext());
        } else if (i == 1) {
            frsActivity = this.aMc.aKd;
            com.baidu.tbadk.core.util.az.q(frsActivity.getPageContext().getPageActivity());
        }
    }
}
