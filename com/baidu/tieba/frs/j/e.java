package com.baidu.tieba.frs.j;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d bTI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bTI = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        frsActivity = this.bTI.bGh;
        if (frsActivity != null) {
            frsActivity2 = this.bTI.bGh;
            TiebaStatic.eventStat(frsActivity2.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            frsActivity3 = this.bTI.bGh;
            if (!frsActivity3.VV()) {
                frsActivity4 = this.bTI.bGh;
                if (frsActivity4.Wj() != null) {
                    frsActivity5 = this.bTI.bGh;
                    frsActivity5.Wj().jA();
                }
            }
        }
    }
}
