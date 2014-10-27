package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        TiebaStatic.eventStat(this.aBk, "frs_pulldown", "frsclick", 1, new Object[0]);
        this.aBk.refresh();
    }
}
