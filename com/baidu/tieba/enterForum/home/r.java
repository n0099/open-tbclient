package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.enterForum.home.i;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ i bbw;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.v bbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(i iVar, com.baidu.tieba.tbadkCore.v vVar) {
        this.bbw = iVar;
        this.bbx = vVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        if (!com.baidu.adp.lib.util.k.jw()) {
            this.bbw.aNm.showToast(t.j.delete_like_fail);
        } else {
            new i.a(this.bbx).execute(new com.baidu.tieba.tbadkCore.v[0]);
        }
        TiebaStatic.eventStat(this.bbw.aNm.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        aVar.dismiss();
    }
}
