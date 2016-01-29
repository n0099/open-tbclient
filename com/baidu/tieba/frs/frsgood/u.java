package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class u implements r.a {
    final /* synthetic */ FrsGoodActivity bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsGoodActivity frsGoodActivity) {
        this.bnm = frsGoodActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        TiebaStatic.eventStat(this.bnm.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.bnm.cy(true);
    }
}
