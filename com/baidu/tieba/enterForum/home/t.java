package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.l;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ l bEU;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.u bEV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(l lVar, com.baidu.tieba.tbadkCore.u uVar) {
        this.bEU = lVar;
        this.bEV = uVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.hA()) {
            this.bEU.aXt.showToast(w.l.delete_like_fail);
        } else {
            new l.a(this.bEV).execute(new com.baidu.tieba.tbadkCore.u[0]);
        }
        TiebaStatic.eventStat(this.bEU.aXt.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
