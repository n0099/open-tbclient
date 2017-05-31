package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.tbadkCore.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements HorizontalTabView.a {
    final /* synthetic */ a bZe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bZe = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void a(j jVar) {
        n nVar;
        n nVar2;
        n nVar3;
        nVar = this.bZe.bZb;
        if (nVar != null) {
            nVar2 = this.bZe.bZb;
            if (nVar2.aIz() != null) {
                as asVar = new as("c12047");
                nVar3 = this.bZe.bZb;
                TiebaStatic.log(asVar.Z("fid", nVar3.aIz().getId()));
            }
        }
    }
}
