package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class af implements com.baidu.tbadk.core.view.aj {
    final /* synthetic */ FrsActivity aLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity) {
        this.aLX = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.aLX.refresh();
    }
}
