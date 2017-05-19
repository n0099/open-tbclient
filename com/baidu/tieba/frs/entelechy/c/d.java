package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.tbadkCore.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements HorizontalTabView.a {
    final /* synthetic */ a bTm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bTm = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void a(j jVar) {
        n nVar;
        n nVar2;
        n nVar3;
        nVar = this.bTm.bTj;
        if (nVar != null) {
            nVar2 = this.bTm.bTj;
            if (nVar2.aHE() != null) {
                as asVar = new as("c12047");
                nVar3 = this.bTm.bTj;
                TiebaStatic.log(asVar.aa("fid", nVar3.aHE().getId()));
            }
        }
    }
}
