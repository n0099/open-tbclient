package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements c.b {
    final /* synthetic */ az bRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(az azVar) {
        this.bRf = azVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.bRf.bQw;
            frsActivity2.Qz();
        } else if (i == 1) {
            frsActivity = this.bRf.bQw;
            com.baidu.tbadk.core.util.ap.p(frsActivity.getPageContext().getPageActivity());
        }
    }
}
