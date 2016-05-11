package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
class l implements BdExpandListView.a {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void k(float f) {
        cn cnVar;
        cn cnVar2;
        cnVar = this.bhl.bgo;
        if (cnVar.QC() instanceof com.baidu.tieba.frs.tab.h) {
            cnVar2 = this.bhl.bgo;
            ((com.baidu.tieba.frs.tab.h) cnVar2.QC()).j(f);
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void jl() {
        cn cnVar;
        cn cnVar2;
        cnVar = this.bhl.bgo;
        if (cnVar.QC() instanceof com.baidu.tieba.frs.tab.h) {
            cnVar2 = this.bhl.bgo;
            ((com.baidu.tieba.frs.tab.h) cnVar2.QC()).Pl();
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void jm() {
        cn cnVar;
        cn cnVar2;
        cn cnVar3;
        cn cnVar4;
        cn cnVar5;
        if (com.baidu.adp.lib.util.i.fq()) {
            cnVar3 = this.bhl.bgo;
            if (cnVar3.QC() instanceof com.baidu.tieba.frs.tab.h) {
                cnVar4 = this.bhl.bgo;
                ((com.baidu.tieba.frs.tab.h) cnVar4.QC()).jk();
                cnVar5 = this.bhl.bgo;
                cnVar5.cQ(true);
            }
            TiebaStatic.eventStat(this.bhl.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            this.bhl.refresh();
            return;
        }
        cnVar = this.bhl.bgo;
        if (cnVar.QC() instanceof com.baidu.tieba.frs.tab.h) {
            cnVar2 = this.bhl.bgo;
            ((com.baidu.tieba.frs.tab.h) cnVar2.QC()).Pl();
        }
    }
}
