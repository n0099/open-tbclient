package com.baidu.tieba.frs.view;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements a.b {
    final /* synthetic */ t brL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar) {
        this.brL = tVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        TiebaStatic.eventStat(this.brL.bgW.getPageContext().getPageActivity(), "consume_7", "click");
        aVar.dismiss();
    }
}
