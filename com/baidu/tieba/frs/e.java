package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.q;
/* loaded from: classes.dex */
class e implements q.a {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        TiebaStatic.eventStat(this.bag.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.bag.refresh();
    }
}
