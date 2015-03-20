package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ bf aLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bf bfVar) {
        this.aLR = bfVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        eVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.aLR.aJT;
            com.baidu.tbadk.core.util.az.d(frsActivity2.getPageContext());
        } else if (i == 1) {
            frsActivity = this.aLR.aJT;
            com.baidu.tbadk.core.util.az.q(frsActivity.getPageContext().getPageActivity());
        }
    }
}
