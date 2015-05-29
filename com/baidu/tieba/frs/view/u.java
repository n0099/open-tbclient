package com.baidu.tieba.frs.view;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ o aRA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar) {
        this.aRA = oVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TiebaStatic.eventStat(this.aRA.aMk.getPageContext().getPageActivity(), "consume_7", "click");
        aVar.dismiss();
    }
}
