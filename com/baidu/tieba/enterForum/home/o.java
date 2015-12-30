package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ i aUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar) {
        this.aUE = iVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        TiebaStatic.eventStat(this.aUE.aJl.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.aUE.aUl.KY();
        this.aUE.aUr = System.currentTimeMillis();
        cVar = this.aUE.aUm;
        j = this.aUE.aUr;
        cVar.ar(j);
        aVar.dismiss();
    }
}
