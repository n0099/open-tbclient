package com.baidu.tieba.frs.frsgood;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.s;
/* loaded from: classes.dex */
class u implements s.a {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsGoodActivity frsGoodActivity) {
        this.bsj = frsGoodActivity;
    }

    @Override // com.baidu.tbadk.core.view.s.a
    public void aB(boolean z) {
        TiebaStatic.eventStat(this.bsj.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.bsj.cK(true);
    }
}
