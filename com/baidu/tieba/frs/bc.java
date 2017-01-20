package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements c.b {
    final /* synthetic */ ax bHQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ax axVar) {
        this.bHQ = axVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.bHQ.bHh;
            frsActivity2.Ot();
        } else if (i == 1) {
            frsActivity = this.bHQ.bHh;
            com.baidu.tbadk.core.util.ao.p(frsActivity.getPageContext().getPageActivity());
        }
    }
}
