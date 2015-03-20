package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class af implements com.baidu.tbadk.core.view.ae {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity) {
        this.aJG = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        TiebaStatic.eventStat(this.aJG.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.aJG.refresh();
    }
}
