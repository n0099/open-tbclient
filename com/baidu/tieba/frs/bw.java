package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements c.b {
    final /* synthetic */ bm bRV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bm bmVar) {
        this.bRV = bmVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.bRV.bRi;
            frsActivity2.abo();
        } else if (i == 1) {
            frsActivity = this.bRV.bRi;
            com.baidu.tbadk.core.util.au.p(frsActivity.getPageContext().getPageActivity());
        }
    }
}
