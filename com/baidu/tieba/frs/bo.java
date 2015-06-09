package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ bf aOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bf bfVar) {
        this.aOn = bfVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        eVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.aOn.aMl;
            com.baidu.tbadk.core.util.ax.b(frsActivity2.getPageContext());
        } else if (i == 1) {
            frsActivity = this.aOn.aMl;
            com.baidu.tbadk.core.util.ax.p(frsActivity.getPageContext().getPageActivity());
        }
    }
}
