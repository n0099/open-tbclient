package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class e implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.aCV.refresh();
    }
}
