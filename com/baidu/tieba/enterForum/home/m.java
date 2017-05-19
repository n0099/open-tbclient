package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.i;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements a.b {
    final /* synthetic */ i bGZ;
    private final /* synthetic */ com.baidu.tieba.enterForum.b.g bHa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar, com.baidu.tieba.enterForum.b.g gVar) {
        this.bGZ = iVar;
        this.bHa = gVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.hB()) {
            this.bGZ.aXS.showToast(w.l.delete_like_fail);
        } else {
            new i.a(this.bHa).execute(new com.baidu.tieba.enterForum.b.g[0]);
        }
        TiebaStatic.eventStat(this.bGZ.aXS.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
