package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements c.b {
    final /* synthetic */ cn bjV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cn cnVar) {
        this.bjV = cnVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.bjV.bgW;
            com.baidu.tbadk.core.util.aq.c(frsActivity2.getPageContext());
        } else if (i == 1) {
            frsActivity = this.bjV.bgW;
            com.baidu.tbadk.core.util.aq.p(frsActivity.getPageContext().getPageActivity());
        }
    }
}
