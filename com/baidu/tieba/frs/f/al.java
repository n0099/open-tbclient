package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements BdExpandListView.a {
    final /* synthetic */ af bVV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(af afVar) {
        this.bVV = afVar;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void G(float f) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        axVar = this.bVV.bFF;
        if (axVar != null) {
            axVar2 = this.bVV.bFF;
            if (axVar2.Yn() instanceof com.baidu.tieba.frs.tab.h) {
                axVar3 = this.bVV.bFF;
                ((com.baidu.tieba.frs.tab.h) axVar3.Yn()).F(f);
            }
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void ke() {
        ax axVar;
        ax axVar2;
        ax axVar3;
        axVar = this.bVV.bFF;
        if (axVar != null) {
            axVar2 = this.bVV.bFF;
            if (axVar2.Yn() instanceof com.baidu.tieba.frs.tab.h) {
                axVar3 = this.bVV.bFF;
                ((com.baidu.tieba.frs.tab.h) axVar3.Yn()).acA();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (((com.baidu.tieba.view.BdExpandListView) r0.Iv()).bgS() == false) goto L20;
     */
    @Override // com.baidu.tieba.view.BdExpandListView.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void kf() {
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
        axVar = this.bVV.bFF;
        if (axVar != null) {
            axVar10 = this.bVV.bFF;
            if (axVar10.JX() != null) {
                axVar11 = this.bVV.bFF;
                axVar11.JX().amY();
            }
        }
        cc.Rx().cN(false);
        frsActivity = this.bVV.bLZ;
        com.baidu.tieba.tbadkCore.n XW = frsActivity.XW();
        axVar2 = this.bVV.bFF;
        if (axVar2 != null && XW != null) {
            frsModelController = this.bVV.bFQ;
            if (frsModelController != null) {
                if (com.baidu.adp.lib.util.i.gk()) {
                    axVar5 = this.bVV.bFF;
                    if (axVar5.Yn() instanceof com.baidu.tieba.frs.tab.h) {
                        axVar6 = this.bVV.bFF;
                        if (axVar6.Iv() instanceof BdExpandListView) {
                            axVar9 = this.bVV.bFF;
                        }
                        axVar7 = this.bVV.bFF;
                        ((com.baidu.tieba.frs.tab.h) axVar7.Yn()).kd();
                        axVar8 = this.bVV.bFF;
                        axVar8.cf(true);
                    }
                    frsActivity4 = this.bVV.bLZ;
                    TiebaStatic.eventStat(frsActivity4.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                    if (XW.aJY() != null && XW.fnk == 1) {
                        frsModelController2 = this.bVV.bFQ;
                        com.baidu.tieba.frs.e.b.a(XW, frsModelController2.aca(), 1);
                    }
                    frsActivity5 = this.bVV.bLZ;
                    frsActivity5.refresh();
                } else {
                    axVar3 = this.bVV.bFF;
                    if (axVar3.Yn() instanceof com.baidu.tieba.frs.tab.h) {
                        axVar4 = this.bVV.bFF;
                        ((com.baidu.tieba.frs.tab.h) axVar4.Yn()).acA();
                    }
                }
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c11749");
                frsActivity2 = this.bVV.bLZ;
                com.baidu.tbadk.core.util.ar ab = arVar.ab("fid", frsActivity2.getFid());
                frsActivity3 = this.bVV.bLZ;
                TiebaStatic.log(ab.ab("obj_locate", frsActivity3.XM() ? "2" : "1"));
            }
        }
    }
}
