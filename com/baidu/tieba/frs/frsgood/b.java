package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsGoodActivity frsGoodActivity) {
        this.bsj = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == t.g.refresh_layout) {
            TiebaStatic.eventStat(this.bsj.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            this.bsj.bsd.nk();
        }
    }
}
