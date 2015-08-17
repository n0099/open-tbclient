package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.d;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ d aMD;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.u aME;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar, com.baidu.tieba.tbadkCore.u uVar) {
        this.aMD = dVar;
        this.aME = uVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        if (com.baidu.adp.lib.util.k.jf()) {
            new d.a(this.aME).execute(new com.baidu.tieba.tbadkCore.u[0]);
        } else {
            this.aMD.showToast(i.C0057i.delete_like_fail);
        }
        TiebaStatic.eventStat(this.aMD.aGD.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
