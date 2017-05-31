package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ae;
import com.baidu.tieba.frs.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements ae.b {
    final /* synthetic */ ag cif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.cif = agVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.frs.r rVar;
        au auVar;
        au auVar2;
        com.baidu.tieba.frs.r rVar2;
        com.baidu.tieba.frs.r rVar3;
        rVar = this.cif.bTw;
        rVar.refresh();
        auVar = this.cif.bUa;
        if (auVar != null) {
            auVar2 = this.cif.bUa;
            auVar2.cf(true);
            rVar2 = this.cif.bTw;
            rVar2.eb(true);
            as asVar = new as("c11749");
            rVar3 = this.cif.bTw;
            TiebaStatic.log(asVar.Z("fid", rVar3.getFid()).Z("obj_locate", "1"));
        }
    }
}
