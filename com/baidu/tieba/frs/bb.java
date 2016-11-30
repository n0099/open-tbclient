package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements c.b {
    final /* synthetic */ au bUk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(au auVar) {
        this.bUk = auVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.bUk.bTA;
            frsActivity2.acy();
        } else if (i == 1) {
            frsActivity = this.bUk.bTA;
            com.baidu.tbadk.core.util.as.p(frsActivity.getPageContext().getPageActivity());
        }
    }
}
