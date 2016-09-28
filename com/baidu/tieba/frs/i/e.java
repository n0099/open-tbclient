package com.baidu.tieba.frs.i;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d ceP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ceP = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        frsActivity = this.ceP.bRi;
        if (frsActivity != null) {
            frsActivity2 = this.ceP.bRi;
            TiebaStatic.eventStat(frsActivity2.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            frsActivity3 = this.ceP.bRi;
            if (!frsActivity3.abf()) {
                frsActivity4 = this.ceP.bRi;
                if (frsActivity4.abs() != null) {
                    frsActivity5 = this.ceP.bRi;
                    frsActivity5.abs().kv();
                }
            }
        }
    }
}
