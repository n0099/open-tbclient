package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
class q implements BdExpandListView.a {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void k(float f) {
        bq bqVar;
        bq bqVar2;
        bqVar = this.bDB.bCD;
        if (bqVar.Wa() instanceof com.baidu.tieba.frs.tab.h) {
            bqVar2 = this.bDB.bCD;
            ((com.baidu.tieba.frs.tab.h) bqVar2.Wa()).j(f);
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void jo() {
        bq bqVar;
        bq bqVar2;
        bqVar = this.bDB.bCD;
        if (bqVar.Wa() instanceof com.baidu.tieba.frs.tab.h) {
            bqVar2 = this.bDB.bCD;
            ((com.baidu.tieba.frs.tab.h) bqVar2.Wa()).US();
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void jp() {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        if (com.baidu.adp.lib.util.i.fr()) {
            bqVar3 = this.bDB.bCD;
            if (bqVar3.Wa() instanceof com.baidu.tieba.frs.tab.h) {
                if (!(this.bDB.getListView() instanceof BdExpandListView) || !((BdExpandListView) this.bDB.getListView()).bjn()) {
                    bqVar4 = this.bDB.bCD;
                    ((com.baidu.tieba.frs.tab.h) bqVar4.Wa()).jn();
                }
                bqVar5 = this.bDB.bCD;
                bqVar5.dm(true);
            }
            TiebaStatic.eventStat(this.bDB.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            this.bDB.refresh();
            return;
        }
        bqVar = this.bDB.bCD;
        if (bqVar.Wa() instanceof com.baidu.tieba.frs.tab.h) {
            bqVar2 = this.bDB.bCD;
            ((com.baidu.tieba.frs.tab.h) bqVar2.Wa()).US();
        }
    }
}
