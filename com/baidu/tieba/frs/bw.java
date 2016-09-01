package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements c.b {
    final /* synthetic */ bm bSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bm bmVar) {
        this.bSc = bmVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.bSc.bRp;
            frsActivity2.abc();
        } else if (i == 1) {
            frsActivity = this.bSc.bRp;
            com.baidu.tbadk.core.util.au.p(frsActivity.getPageContext().getPageActivity());
        }
    }
}
