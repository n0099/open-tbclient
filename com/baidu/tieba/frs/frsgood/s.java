package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class s implements r.a {
    final /* synthetic */ FrsGoodActivity bkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsGoodActivity frsGoodActivity) {
        this.bkp = frsGoodActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        TiebaStatic.eventStat(this.bkp.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.bkp.cy(true);
    }
}
