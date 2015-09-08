package com.baidu.tieba.frs.view;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ p bdt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.bdt = pVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TiebaStatic.eventStat(this.bdt.aVM.getPageContext().getPageActivity(), "consume_7", "click");
        aVar.dismiss();
    }
}
