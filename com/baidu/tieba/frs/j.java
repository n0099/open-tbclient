package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        TiebaStatic.eventStat(this.aBu, "frs_pulldown", "frsclick", 1, new Object[0]);
        this.aBu.refresh();
    }
}
