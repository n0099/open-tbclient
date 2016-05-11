package com.baidu.tieba.frs.h;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a btY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.btY = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        frsActivity = this.btY.bjB;
        if (frsActivity != null) {
            frsActivity2 = this.btY.bjB;
            TiebaStatic.eventStat(frsActivity2.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            frsActivity3 = this.btY.bjB;
            if (!frsActivity3.Qa()) {
                frsActivity4 = this.btY.bjB;
                if (frsActivity4.Qn() != null) {
                    frsActivity5 = this.btY.bjB;
                    frsActivity5.Qn().jy();
                }
            }
        }
    }
}
