package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements c.b {
    final /* synthetic */ x aZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar) {
        this.aZS = xVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        FrsGoodActivity frsGoodActivity;
        FrsGoodActivity frsGoodActivity2;
        cVar.dismiss();
        if (i == 0) {
            frsGoodActivity2 = this.aZS.aWL;
            ak.c(frsGoodActivity2.getPageContext());
        } else if (i == 1) {
            frsGoodActivity = this.aZS.aWL;
            ak.p(frsGoodActivity.getPageContext().getPageActivity());
        }
    }
}
