package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class o implements a.b {
    final /* synthetic */ n boc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.boc = nVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        frsActivity = this.boc.bjB;
        TiebaStatic.eventStat(frsActivity.getPageContext().getPageActivity(), "consume_7", "click");
        aVar.dismiss();
    }
}
