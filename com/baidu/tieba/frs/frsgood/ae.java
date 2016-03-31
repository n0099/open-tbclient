package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements c.b {
    final /* synthetic */ y bst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(y yVar) {
        this.bst = yVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsGoodActivity frsGoodActivity;
        FrsGoodActivity frsGoodActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsGoodActivity2 = this.bst.bnM;
            frsGoodActivity2.Rh();
        } else if (i == 1) {
            frsGoodActivity = this.bst.bnM;
            as.j(frsGoodActivity.getPageContext().getPageActivity());
        }
    }
}
