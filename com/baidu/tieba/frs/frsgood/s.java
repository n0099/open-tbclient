package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class s implements p.a {
    final /* synthetic */ FrsGoodActivity baf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsGoodActivity frsGoodActivity) {
        this.baf = frsGoodActivity;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        TiebaStatic.eventStat(this.baf.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.baf.ck(true);
    }
}
