package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.i;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements a.b {
    final /* synthetic */ i bMN;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.g bMO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar, com.baidu.tieba.enterForum.b.g gVar) {
        this.bMN = iVar;
        this.bMO = gVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.hB()) {
            this.bMN.aVu.showToast(w.l.delete_like_fail);
        } else {
            new i.a(this.bMO).execute(new com.baidu.tieba.enterForum.b.g[0]);
        }
        TiebaStatic.eventStat(this.bMN.aVu.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
