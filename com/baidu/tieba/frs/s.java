package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.g.b;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
class s implements BdExpandListView.a {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void G(float f) {
        bm bmVar;
        bm bmVar2;
        bmVar = this.bQi.bPi;
        if (bmVar.abA() instanceof com.baidu.tieba.frs.tab.h) {
            bmVar2 = this.bQi.bPi;
            ((com.baidu.tieba.frs.tab.h) bmVar2.abA()).F(f);
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void ki() {
        bm bmVar;
        bm bmVar2;
        bmVar = this.bQi.bPi;
        if (bmVar.abA() instanceof com.baidu.tieba.frs.tab.h) {
            bmVar2 = this.bQi.bPi;
            ((com.baidu.tieba.frs.tab.h) bmVar2.abA()).afo();
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void kj() {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        com.baidu.tieba.card.cb.Oj().cs(false);
        if (com.baidu.adp.lib.util.i.gm()) {
            bmVar3 = this.bQi.bPi;
            if (bmVar3.abA() instanceof com.baidu.tieba.frs.tab.h) {
                if (!(this.bQi.getListView() instanceof BdExpandListView) || !((BdExpandListView) this.bQi.getListView()).bqN()) {
                    bmVar4 = this.bQi.bPi;
                    ((com.baidu.tieba.frs.tab.h) bmVar4.abA()).kh();
                }
                bmVar5 = this.bQi.bPi;
                bmVar5.dI(true);
            }
            TiebaStatic.eventStat(this.bQi.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (this.bQi.bPk != null && this.bQi.bPk.aMr() != null && this.bQi.bPk.fsD == 1 && this.bQi.abi() != null) {
                b.a(this.bQi.bPk, this.bQi.abi().acs(), 1);
            }
            this.bQi.refresh();
            return;
        }
        bmVar = this.bQi.bPi;
        if (bmVar.abA() instanceof com.baidu.tieba.frs.tab.h) {
            bmVar2 = this.bQi.bPi;
            ((com.baidu.tieba.frs.tab.h) bmVar2.abA()).afo();
        }
    }
}
