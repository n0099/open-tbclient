package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.k;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ k btA;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.x btB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(k kVar, com.baidu.tieba.tbadkCore.x xVar) {
        this.btA = kVar;
        this.btB = xVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.fI()) {
            this.btA.aMU.showToast(u.j.delete_like_fail);
        } else {
            new k.a(this.btB).execute(new com.baidu.tieba.tbadkCore.x[0]);
        }
        TiebaStatic.eventStat(this.btA.aMU.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
