package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class af implements com.baidu.tbadk.core.view.aj {
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity) {
        this.aLY = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.aLY.refresh();
    }
}
