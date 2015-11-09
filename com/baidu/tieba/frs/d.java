package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class d implements p.a {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        TiebaStatic.eventStat(this.aUS.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.aUS.refresh();
    }
}
