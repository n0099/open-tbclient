package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements c.b {
    final /* synthetic */ cn bkx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cn cnVar) {
        this.bkx = cnVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.bkx.bjB;
            frsActivity2.Qj();
        } else if (i == 1) {
            frsActivity = this.bkx.bjB;
            com.baidu.tbadk.core.util.as.j(frsActivity.getPageContext().getPageActivity());
        }
    }
}
