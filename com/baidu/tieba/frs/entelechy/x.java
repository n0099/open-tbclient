package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class x implements a.b {
    final /* synthetic */ u bYy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.bYy = uVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        frsActivity = this.bYy.bTA;
        TiebaStatic.eventStat(frsActivity.getPageContext().getPageActivity(), "consume_7", "click");
        aVar.dismiss();
    }
}
