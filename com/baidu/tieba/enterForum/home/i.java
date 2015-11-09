package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.b {
    final /* synthetic */ d aMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.aMe = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        TiebaStatic.eventStat(this.aMe.aEO.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.aMe.aLN.Jk();
        this.aMe.aLT = System.currentTimeMillis();
        cVar = this.aMe.aLO;
        j = this.aMe.aLT;
        cVar.ai(j);
        aVar.dismiss();
    }
}
