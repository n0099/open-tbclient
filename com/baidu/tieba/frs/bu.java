package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements c.b {
    final /* synthetic */ bl aXC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bl blVar) {
        this.aXC = blVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.aXC.aVx;
            com.baidu.tbadk.core.util.ak.c(frsActivity2.getPageContext());
        } else if (i == 1) {
            frsActivity = this.aXC.aVx;
            com.baidu.tbadk.core.util.ak.p(frsActivity.getPageContext().getPageActivity());
        }
    }
}
