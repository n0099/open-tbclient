package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class s implements p.a {
    final /* synthetic */ FrsGoodActivity aZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsGoodActivity frsGoodActivity) {
        this.aZM = frsGoodActivity;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        TiebaStatic.eventStat(this.aZM.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.aZM.ci(true);
    }
}
