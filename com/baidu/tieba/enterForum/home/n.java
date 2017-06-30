package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.i;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements a.b {
    final /* synthetic */ i bTq;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.g bTr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar, com.baidu.tieba.enterForum.b.g gVar) {
        this.bTq = iVar;
        this.bTr = gVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.hA()) {
            this.bTq.aWN.showToast(w.l.delete_like_fail);
        } else {
            new i.a(this.bTr).execute(new com.baidu.tieba.enterForum.b.g[0]);
        }
        TiebaStatic.eventStat(this.bTq.aWN.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
