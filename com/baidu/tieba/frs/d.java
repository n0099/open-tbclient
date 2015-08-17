package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.x;
/* loaded from: classes.dex */
class d implements x.a {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.this$0.refresh();
    }
}
