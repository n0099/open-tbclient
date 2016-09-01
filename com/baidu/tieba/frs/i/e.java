package com.baidu.tieba.frs.i;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d ceQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ceQ = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        frsActivity = this.ceQ.bRp;
        if (frsActivity != null) {
            frsActivity2 = this.ceQ.bRp;
            TiebaStatic.eventStat(frsActivity2.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            frsActivity3 = this.ceQ.bRp;
            if (!frsActivity3.aaS()) {
                frsActivity4 = this.ceQ.bRp;
                if (frsActivity4.abg() != null) {
                    frsActivity5 = this.ceQ.bRp;
                    frsActivity5.abg().kv();
                }
            }
        }
    }
}
