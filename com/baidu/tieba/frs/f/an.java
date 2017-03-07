package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements BdExpandListView.a {
    final /* synthetic */ ah cdq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ah ahVar) {
        this.cdq = ahVar;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void G(float f) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        axVar = this.cdq.bMN;
        if (axVar != null) {
            axVar2 = this.cdq.bMN;
            if (axVar2.Zm() instanceof com.baidu.tieba.frs.tab.h) {
                axVar3 = this.cdq.bMN;
                ((com.baidu.tieba.frs.tab.h) axVar3.Zm()).F(f);
            }
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void kY() {
        ax axVar;
        ax axVar2;
        ax axVar3;
        axVar = this.cdq.bMN;
        if (axVar != null) {
            axVar2 = this.cdq.bMN;
            if (axVar2.Zm() instanceof com.baidu.tieba.frs.tab.h) {
                axVar3 = this.cdq.bMN;
                ((com.baidu.tieba.frs.tab.h) axVar3.Zm()).ady();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (((com.baidu.tieba.view.BdExpandListView) r0.getListView()).bgF() == false) goto L20;
     */
    @Override // com.baidu.tieba.view.BdExpandListView.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void kZ() {
        ax axVar;
        FrsActivity frsActivity;
        ax axVar2;
        FrsModelController frsModelController;
        ax axVar3;
        ax axVar4;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        ax axVar5;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsModelController frsModelController2;
        ax axVar6;
        ax axVar7;
        ax axVar8;
        ax axVar9;
        ax axVar10;
        ax axVar11;
        axVar = this.cdq.bMN;
        if (axVar != null) {
            axVar10 = this.cdq.bMN;
            if (axVar10.KC() != null) {
                axVar11 = this.cdq.bMN;
                axVar11.KC().alL();
            }
        }
        cc.Sv().cN(false);
        frsActivity = this.cdq.bTf;
        com.baidu.tieba.tbadkCore.n YV = frsActivity.YV();
        axVar2 = this.cdq.bMN;
        if (axVar2 != null && YV != null) {
            frsModelController = this.cdq.bMY;
            if (frsModelController != null) {
                if (com.baidu.adp.lib.util.i.he()) {
                    axVar5 = this.cdq.bMN;
                    if (axVar5.Zm() instanceof com.baidu.tieba.frs.tab.h) {
                        axVar6 = this.cdq.bMN;
                        if (axVar6.getListView() instanceof BdExpandListView) {
                            axVar9 = this.cdq.bMN;
                        }
                        axVar7 = this.cdq.bMN;
                        ((com.baidu.tieba.frs.tab.h) axVar7.Zm()).kX();
                        axVar8 = this.cdq.bMN;
                        axVar8.ce(true);
                    }
                    frsActivity4 = this.cdq.bTf;
                    TiebaStatic.eventStat(frsActivity4.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                    if (YV.aJp() != null && YV.frI == 1) {
                        frsModelController2 = this.cdq.bMY;
                        com.baidu.tieba.frs.e.b.a(YV, frsModelController2.acX(), 1);
                    }
                    frsActivity5 = this.cdq.bTf;
                    frsActivity5.refresh();
                } else {
                    axVar3 = this.cdq.bMN;
                    if (axVar3.Zm() instanceof com.baidu.tieba.frs.tab.h) {
                        axVar4 = this.cdq.bMN;
                        ((com.baidu.tieba.frs.tab.h) axVar4.Zm()).ady();
                    }
                }
                com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11749");
                frsActivity2 = this.cdq.bTf;
                com.baidu.tbadk.core.util.as Z = asVar.Z("fid", frsActivity2.getFid());
                frsActivity3 = this.cdq.bTf;
                TiebaStatic.log(Z.Z("obj_locate", frsActivity3.YL() ? "2" : "1"));
            }
        }
    }
}
