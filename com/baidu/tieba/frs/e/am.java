package com.baidu.tieba.frs.e;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements BdExpandListView.a {
    final /* synthetic */ ag cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar) {
        this.cbR = agVar;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void G(float f) {
        at atVar;
        at atVar2;
        at atVar3;
        atVar = this.cbR.bOn;
        if (atVar != null) {
            atVar2 = this.cbR.bOn;
            if (atVar2.Zz() instanceof com.baidu.tieba.frs.tab.i) {
                atVar3 = this.cbR.bOn;
                ((com.baidu.tieba.frs.tab.i) atVar3.Zz()).F(f);
            }
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void lc() {
        at atVar;
        at atVar2;
        at atVar3;
        atVar = this.cbR.bOn;
        if (atVar != null) {
            atVar2 = this.cbR.bOn;
            if (atVar2.Zz() instanceof com.baidu.tieba.frs.tab.i) {
                atVar3 = this.cbR.bOn;
                ((com.baidu.tieba.frs.tab.i) atVar3.Zz()).acw();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (((com.baidu.tieba.view.BdExpandListView) r0.getListView()).bfP() == false) goto L20;
     */
    @Override // com.baidu.tieba.view.BdExpandListView.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ld() {
        at atVar;
        com.baidu.tieba.frs.r rVar;
        at atVar2;
        FrsModelController frsModelController;
        at atVar3;
        at atVar4;
        com.baidu.tieba.frs.r rVar2;
        at atVar5;
        com.baidu.tieba.frs.r rVar3;
        com.baidu.tieba.frs.r rVar4;
        FrsModelController frsModelController2;
        at atVar6;
        at atVar7;
        at atVar8;
        at atVar9;
        at atVar10;
        at atVar11;
        atVar = this.cbR.bOn;
        if (atVar != null) {
            atVar10 = this.cbR.bOn;
            if (atVar10.Kq() != null) {
                atVar11 = this.cbR.bOn;
                atVar11.Kq().ajv();
            }
        }
        ca.To().dc(false);
        rVar = this.cbR.bNK;
        com.baidu.tieba.tbadkCore.n Zq = rVar.Zq();
        atVar2 = this.cbR.bOn;
        if (atVar2 != null && Zq != null) {
            frsModelController = this.cbR.bOw;
            if (frsModelController != null) {
                if (com.baidu.adp.lib.util.i.hk()) {
                    atVar5 = this.cbR.bOn;
                    if (atVar5.Zz() instanceof com.baidu.tieba.frs.tab.i) {
                        atVar6 = this.cbR.bOn;
                        if (atVar6.getListView() instanceof BdExpandListView) {
                            atVar9 = this.cbR.bOn;
                        }
                        atVar7 = this.cbR.bOn;
                        ((com.baidu.tieba.frs.tab.i) atVar7.Zz()).lb();
                        atVar8 = this.cbR.bOn;
                        atVar8.ci(true);
                    }
                    rVar3 = this.cbR.bNK;
                    TiebaStatic.eventStat(rVar3.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                    if (Zq.aHE() != null && Zq.frQ == 1) {
                        frsModelController2 = this.cbR.bOw;
                        com.baidu.tieba.frs.c.b.a(Zq, frsModelController2.abW(), 1);
                    }
                    rVar4 = this.cbR.bNK;
                    rVar4.refresh();
                } else {
                    atVar3 = this.cbR.bOn;
                    if (atVar3.Zz() instanceof com.baidu.tieba.frs.tab.i) {
                        atVar4 = this.cbR.bOn;
                        ((com.baidu.tieba.frs.tab.i) atVar4.Zz()).acw();
                    }
                }
                as asVar = new as("c11749");
                rVar2 = this.cbR.bNK;
                TiebaStatic.log(asVar.aa("fid", rVar2.getFid()).aa("obj_locate", "1"));
            }
        }
    }
}
