package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.l;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements a.b {
    final /* synthetic */ l bHc;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.w bHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(l lVar, com.baidu.tieba.tbadkCore.w wVar) {
        this.bHc = lVar;
        this.bHd = wVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.gD()) {
            this.bHc.aTi.showToast(t.j.delete_like_fail);
        } else {
            new l.a(this.bHd).execute(new com.baidu.tieba.tbadkCore.w[0]);
        }
        TiebaStatic.eventStat(this.bHc.aTi.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
