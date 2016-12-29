package com.baidu.tieba.frs.h;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements BdExpandListView.a {
    final /* synthetic */ ad bPv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ad adVar) {
        this.bPv = adVar;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void G(float f) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        axVar = this.bPv.byg;
        if (axVar != null) {
            axVar2 = this.bPv.byg;
            if (axVar2.WW() instanceof com.baidu.tieba.frs.tab.h) {
                axVar3 = this.bPv.byg;
                ((com.baidu.tieba.frs.tab.h) axVar3.WW()).F(f);
            }
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void ki() {
        ax axVar;
        ax axVar2;
        ax axVar3;
        axVar = this.bPv.byg;
        if (axVar != null) {
            axVar2 = this.bPv.byg;
            if (axVar2.WW() instanceof com.baidu.tieba.frs.tab.h) {
                axVar3 = this.bPv.byg;
                ((com.baidu.tieba.frs.tab.h) axVar3.WW()).abt();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (((com.baidu.tieba.view.BdExpandListView) r0.Xm()).bfd() == false) goto L20;
     */
    @Override // com.baidu.tieba.view.BdExpandListView.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void kj() {
        ax axVar;
        FrsActivity frsActivity;
        ax axVar2;
        com.baidu.tieba.frs.d.i iVar;
        ax axVar3;
        ax axVar4;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        ax axVar5;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        com.baidu.tieba.frs.d.i iVar2;
        ax axVar6;
        ax axVar7;
        ax axVar8;
        ax axVar9;
        ax axVar10;
        ax axVar11;
        axVar = this.bPv.byg;
        if (axVar != null) {
            axVar10 = this.bPv.byg;
            if (axVar10.JI() != null) {
                axVar11 = this.bPv.byg;
                axVar11.JI().alQ();
            }
        }
        bz.OH().cz(false);
        frsActivity = this.bPv.bFI;
        com.baidu.tieba.tbadkCore.o WF = frsActivity.WF();
        axVar2 = this.bPv.byg;
        if (axVar2 != null && WF != null) {
            iVar = this.bPv.byr;
            if (iVar != null) {
                if (com.baidu.adp.lib.util.i.gm()) {
                    axVar5 = this.bPv.byg;
                    if (axVar5.WW() instanceof com.baidu.tieba.frs.tab.h) {
                        axVar6 = this.bPv.byg;
                        if (axVar6.Xm() instanceof BdExpandListView) {
                            axVar9 = this.bPv.byg;
                        }
                        axVar7 = this.bPv.byg;
                        ((com.baidu.tieba.frs.tab.h) axVar7.WW()).kh();
                        axVar8 = this.bPv.byg;
                        axVar8.dw(true);
                    }
                    frsActivity4 = this.bPv.bFI;
                    TiebaStatic.eventStat(frsActivity4.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                    if (WF.aIk() != null && WF.fdP == 1) {
                        iVar2 = this.bPv.byr;
                        com.baidu.tieba.frs.g.b.a(WF, iVar2.aaU(), 1);
                    }
                    frsActivity5 = this.bPv.bFI;
                    frsActivity5.refresh();
                } else {
                    axVar3 = this.bPv.byg;
                    if (axVar3.WW() instanceof com.baidu.tieba.frs.tab.h) {
                        axVar4 = this.bPv.byg;
                        ((com.baidu.tieba.frs.tab.h) axVar4.WW()).abt();
                    }
                }
                at atVar = new at("c11749");
                frsActivity2 = this.bPv.bFI;
                at ab = atVar.ab("fid", frsActivity2.getFid());
                frsActivity3 = this.bPv.bFI;
                TiebaStatic.log(ab.ab("obj_locate", frsActivity3.Wv() ? "2" : "1"));
            }
        }
    }
}
