package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.h.b;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
class q implements BdExpandListView.a {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void u(float f) {
        bq bqVar;
        bq bqVar2;
        bqVar = this.bEL.bDK;
        if (bqVar.Wr() instanceof com.baidu.tieba.frs.tab.h) {
            bqVar2 = this.bEL.bDK;
            ((com.baidu.tieba.frs.tab.h) bqVar2.Wr()).t(f);
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void jn() {
        bq bqVar;
        bq bqVar2;
        bqVar = this.bEL.bDK;
        if (bqVar.Wr() instanceof com.baidu.tieba.frs.tab.h) {
            bqVar2 = this.bEL.bDK;
            ((com.baidu.tieba.frs.tab.h) bqVar2.Wr()).aap();
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void jo() {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        com.baidu.tieba.card.bw.Lf().cm(false);
        if (com.baidu.adp.lib.util.i.fq()) {
            bqVar3 = this.bEL.bDK;
            if (bqVar3.Wr() instanceof com.baidu.tieba.frs.tab.h) {
                if (!(this.bEL.getListView() instanceof BdExpandListView) || !((BdExpandListView) this.bEL.getListView()).bmA()) {
                    bqVar4 = this.bEL.bDK;
                    ((com.baidu.tieba.frs.tab.h) bqVar4.Wr()).jm();
                }
                bqVar5 = this.bEL.bDK;
                bqVar5.dj(true);
            }
            TiebaStatic.eventStat(this.bEL.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (this.bEL.bDM != null && this.bEL.bDM.aGX() != null && this.bEL.bDM.fig == 1 && this.bEL.VY() != null) {
                b.a(this.bEL.bDM, this.bEL.VY().Xi(), 1);
            }
            this.bEL.refresh();
            return;
        }
        bqVar = this.bEL.bDK;
        if (bqVar.Wr() instanceof com.baidu.tieba.frs.tab.h) {
            bqVar2 = this.bEL.bDK;
            ((com.baidu.tieba.frs.tab.h) bqVar2.Wr()).aap();
        }
    }
}
