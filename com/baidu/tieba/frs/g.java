package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class g implements r.a {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        TiebaStatic.eventStat(this.bgz.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.bgz.refresh();
    }
}
