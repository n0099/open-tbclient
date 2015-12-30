package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class f implements r.a {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        TiebaStatic.eventStat(this.bed.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.bed.refresh();
    }
}
