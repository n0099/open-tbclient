package com.baidu.tieba.frs.i;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d bRI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bRI = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        frsActivity = this.bRI.bET;
        if (frsActivity != null) {
            frsActivity2 = this.bRI.bET;
            TiebaStatic.eventStat(frsActivity2.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            frsActivity3 = this.bRI.bET;
            if (!frsActivity3.VD()) {
                frsActivity4 = this.bRI.bET;
                if (frsActivity4.VQ() != null) {
                    frsActivity5 = this.bRI.bET;
                    frsActivity5.VQ().jB();
                }
            }
        }
    }
}
