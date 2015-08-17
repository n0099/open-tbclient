package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsGoodActivity frsGoodActivity) {
        this.aZp = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == i.f.refresh_layout) {
            TiebaStatic.eventStat(this.aZp.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            this.aZp.aZj.ny();
        }
    }
}
