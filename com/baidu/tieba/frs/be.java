package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements c.b {
    final /* synthetic */ ax bAv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ax axVar) {
        this.bAv = axVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.bAv.bzH;
            frsActivity2.WL();
        } else if (i == 1) {
            frsActivity = this.bAv.bzH;
            com.baidu.tbadk.core.util.aq.p(frsActivity.getPageContext().getPageActivity());
        }
    }
}
