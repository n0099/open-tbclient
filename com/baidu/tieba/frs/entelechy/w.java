package com.baidu.tieba.frs.entelechy;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class w implements a.b {
    final /* synthetic */ t bRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.bRF = tVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        frsActivity = this.bRF.bOf;
        TiebaStatic.eventStat(frsActivity.getPageContext().getPageActivity(), "consume_7", "click");
        aVar.dismiss();
    }
}
