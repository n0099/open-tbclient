package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements c.b {
    final /* synthetic */ cs bpe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cs csVar) {
        this.bpe = csVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsActivity2 = this.bpe.blH;
            frsActivity2.Rh();
        } else if (i == 1) {
            frsActivity = this.bpe.blH;
            com.baidu.tbadk.core.util.as.j(frsActivity.getPageContext().getPageActivity());
        }
    }
}
