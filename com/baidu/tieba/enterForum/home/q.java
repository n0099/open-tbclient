package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.i;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.b {
    final /* synthetic */ i aUE;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.w aUF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(i iVar, com.baidu.tieba.tbadkCore.w wVar) {
        this.aUE = iVar;
        this.aUF = wVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.jh()) {
            this.aUE.aJl.showToast(n.j.delete_like_fail);
        } else {
            new i.a(this.aUF).execute(new com.baidu.tieba.tbadkCore.w[0]);
        }
        TiebaStatic.eventStat(this.aUE.aJl.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
