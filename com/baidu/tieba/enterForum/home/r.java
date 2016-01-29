package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.i;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ i aWN;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.v aWO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(i iVar, com.baidu.tieba.tbadkCore.v vVar) {
        this.aWN = iVar;
        this.aWO = vVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.jq()) {
            this.aWN.aKq.showToast(t.j.delete_like_fail);
        } else {
            new i.a(this.aWO).execute(new com.baidu.tieba.tbadkCore.v[0]);
        }
        TiebaStatic.eventStat(this.aWN.aKq.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
