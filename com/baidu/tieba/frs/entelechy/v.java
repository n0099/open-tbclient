package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class v implements a.b {
    final /* synthetic */ u bVt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bVt = uVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        frsActivity = this.bVt.bRp;
        TiebaStatic.eventStat(frsActivity.getPageContext().getPageActivity(), "consume_7", "click");
        aVar.dismiss();
    }
}
