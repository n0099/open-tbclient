package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.s;
/* loaded from: classes.dex */
class h implements s.a {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.s.a
    public void aB(boolean z) {
        TiebaStatic.eventStat(this.blk.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
        this.blk.refresh();
    }
}
