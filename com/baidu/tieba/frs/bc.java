package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements c.b {
    final /* synthetic */ ax bOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ax axVar) {
        this.bOZ = axVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.bOZ.bOq;
            frsActivity2.Pn();
        } else if (i == 1) {
            frsActivity = this.bOZ.bOq;
            com.baidu.tbadk.core.util.ap.p(frsActivity.getPageContext().getPageActivity());
        }
    }
}
