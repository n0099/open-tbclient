package com.baidu.tieba.frs.view;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements a.b {
    final /* synthetic */ q bdC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar) {
        this.bdC = qVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        TiebaStatic.eventStat(this.bdC.aUU.getPageContext().getPageActivity(), "consume_7", "click");
        aVar.dismiss();
    }
}
