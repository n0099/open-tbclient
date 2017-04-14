package com.baidu.tieba.frs.g;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements BdExpandListView.a {
    final /* synthetic */ ah cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ah ahVar) {
        this.cbR = ahVar;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void G(float f) {
        az azVar;
        az azVar2;
        az azVar3;
        azVar = this.cbR.bMD;
        if (azVar != null) {
            azVar2 = this.cbR.bMD;
            if (azVar2.ZK() instanceof com.baidu.tieba.frs.tab.h) {
                azVar3 = this.cbR.bMD;
                ((com.baidu.tieba.frs.tab.h) azVar3.ZK()).F(f);
            }
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void lc() {
        az azVar;
        az azVar2;
        az azVar3;
        azVar = this.cbR.bMD;
        if (azVar != null) {
            azVar2 = this.cbR.bMD;
            if (azVar2.ZK() instanceof com.baidu.tieba.frs.tab.h) {
                azVar3 = this.cbR.bMD;
                ((com.baidu.tieba.frs.tab.h) azVar3.ZK()).ads();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (((com.baidu.tieba.view.BdExpandListView) r0.getListView()).bhq() == false) goto L20;
     */
    @Override // com.baidu.tieba.view.BdExpandListView.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ld() {
        az azVar;
        FrsActivity frsActivity;
        az azVar2;
        FrsModelController frsModelController;
        az azVar3;
        az azVar4;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        az azVar5;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsModelController frsModelController2;
        az azVar6;
        az azVar7;
        az azVar8;
        az azVar9;
        az azVar10;
        az azVar11;
        azVar = this.cbR.bMD;
        if (azVar != null) {
            azVar10 = this.cbR.bMD;
            if (azVar10.Lc() != null) {
                azVar11 = this.cbR.bMD;
                azVar11.Lc().alF();
            }
        }
        cc.ST().cP(false);
        frsActivity = this.cbR.bST;
        com.baidu.tieba.tbadkCore.n Zr = frsActivity.Zr();
        azVar2 = this.cbR.bMD;
        if (azVar2 != null && Zr != null) {
            frsModelController = this.cbR.bMO;
            if (frsModelController != null) {
                if (com.baidu.adp.lib.util.i.hj()) {
                    azVar5 = this.cbR.bMD;
                    if (azVar5.ZK() instanceof com.baidu.tieba.frs.tab.h) {
                        azVar6 = this.cbR.bMD;
                        if (azVar6.getListView() instanceof BdExpandListView) {
                            azVar9 = this.cbR.bMD;
                        }
                        azVar7 = this.cbR.bMD;
                        ((com.baidu.tieba.frs.tab.h) azVar7.ZK()).lb();
                        azVar8 = this.cbR.bMD;
                        azVar8.cg(true);
                    }
                    frsActivity4 = this.cbR.bST;
                    TiebaStatic.eventStat(frsActivity4.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                    if (Zr.aJw() != null && Zr.ftt == 1) {
                        frsModelController2 = this.cbR.bMO;
                        com.baidu.tieba.frs.e.b.a(Zr, frsModelController2.acR(), 1);
                    }
                    frsActivity5 = this.cbR.bST;
                    frsActivity5.refresh();
                } else {
                    azVar3 = this.cbR.bMD;
                    if (azVar3.ZK() instanceof com.baidu.tieba.frs.tab.h) {
                        azVar4 = this.cbR.bMD;
                        ((com.baidu.tieba.frs.tab.h) azVar4.ZK()).ads();
                    }
                }
                com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11749");
                frsActivity2 = this.cbR.bST;
                com.baidu.tbadk.core.util.as aa = asVar.aa("fid", frsActivity2.getFid());
                frsActivity3 = this.cbR.bST;
                TiebaStatic.log(aa.aa("obj_locate", frsActivity3.Zh() ? "2" : "1"));
            }
        }
    }
}
