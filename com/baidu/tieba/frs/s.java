package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.g.b;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
class s implements BdExpandListView.a {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.bQp = frsActivity;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void G(float f) {
        bm bmVar;
        bm bmVar2;
        bmVar = this.bQp.bPo;
        if (bmVar.abo() instanceof com.baidu.tieba.frs.tab.h) {
            bmVar2 = this.bQp.bPo;
            ((com.baidu.tieba.frs.tab.h) bmVar2.abo()).F(f);
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void ki() {
        bm bmVar;
        bm bmVar2;
        bmVar = this.bQp.bPo;
        if (bmVar.abo() instanceof com.baidu.tieba.frs.tab.h) {
            bmVar2 = this.bQp.bPo;
            ((com.baidu.tieba.frs.tab.h) bmVar2.abo()).afa();
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void kj() {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        com.baidu.tieba.card.cd.NI().cs(false);
        if (com.baidu.adp.lib.util.i.gm()) {
            bmVar3 = this.bQp.bPo;
            if (bmVar3.abo() instanceof com.baidu.tieba.frs.tab.h) {
                if (!(this.bQp.getListView() instanceof BdExpandListView) || !((BdExpandListView) this.bQp.getListView()).bqj()) {
                    bmVar4 = this.bQp.bPo;
                    ((com.baidu.tieba.frs.tab.h) bmVar4.abo()).kh();
                }
                bmVar5 = this.bQp.bPo;
                bmVar5.dH(true);
            }
            TiebaStatic.eventStat(this.bQp.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
            if (this.bQp.bPq != null && this.bQp.bPq.aLP() != null && this.bQp.bPq.fpX == 1 && this.bQp.aaV() != null) {
                b.a(this.bQp.bPq, this.bQp.aaV().acf(), 1);
            }
            this.bQp.refresh();
            return;
        }
        bmVar = this.bQp.bPo;
        if (bmVar.abo() instanceof com.baidu.tieba.frs.tab.h) {
            bmVar2 = this.bQp.bPo;
            ((com.baidu.tieba.frs.tab.h) bmVar2.abo()).afa();
        }
    }
}
