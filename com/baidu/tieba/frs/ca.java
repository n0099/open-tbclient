package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements c.b {
    final /* synthetic */ bq bFI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bq bqVar) {
        this.bFI = bqVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.bFI.bET;
            frsActivity2.VM();
        } else if (i == 1) {
            frsActivity = this.bFI.bET;
            com.baidu.tbadk.core.util.au.l(frsActivity.getPageContext().getPageActivity());
        }
    }
}
