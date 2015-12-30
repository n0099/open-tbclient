package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity bkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsGoodActivity frsGoodActivity) {
        this.bkp = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == n.g.refresh_layout) {
            TiebaStatic.eventStat(this.bkp.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            this.bkp.bkj.nb();
        }
    }
}
