package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity aZI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsGoodActivity frsGoodActivity) {
        this.aZI = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == i.f.refresh_layout) {
            TiebaStatic.eventStat(this.aZI.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            this.aZI.aZC.nv();
        }
    }
}
