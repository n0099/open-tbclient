package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class q implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        TiebaStatic.eventStat(this.a, "frs_pulldown", "frsclick", 1, new Object[0]);
        this.a.E();
    }
}
