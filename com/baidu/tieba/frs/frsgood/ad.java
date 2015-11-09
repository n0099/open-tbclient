package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements c.b {
    final /* synthetic */ x bap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar) {
        this.bap = xVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsGoodActivity frsGoodActivity;
        FrsGoodActivity frsGoodActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsGoodActivity2 = this.bap.aWx;
            am.c(frsGoodActivity2.getPageContext());
        } else if (i == 1) {
            frsGoodActivity = this.bap.aWx;
            am.p(frsGoodActivity.getPageContext().getPageActivity());
        }
    }
}
