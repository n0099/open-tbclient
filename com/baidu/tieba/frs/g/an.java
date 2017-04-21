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
    final /* synthetic */ ah cei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ah ahVar) {
        this.cei = ahVar;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void G(float f) {
        az azVar;
        az azVar2;
        az azVar3;
        azVar = this.cei.bOU;
        if (azVar != null) {
            azVar2 = this.cei.bOU;
            if (azVar2.aaL() instanceof com.baidu.tieba.frs.tab.h) {
                azVar3 = this.cei.bOU;
                ((com.baidu.tieba.frs.tab.h) azVar3.aaL()).F(f);
            }
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void ld() {
        az azVar;
        az azVar2;
        az azVar3;
        azVar = this.cei.bOU;
        if (azVar != null) {
            azVar2 = this.cei.bOU;
            if (azVar2.aaL() instanceof com.baidu.tieba.frs.tab.h) {
                azVar3 = this.cei.bOU;
                ((com.baidu.tieba.frs.tab.h) azVar3.aaL()).aet();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (((com.baidu.tieba.view.BdExpandListView) r0.getListView()).bir() == false) goto L20;
     */
    @Override // com.baidu.tieba.view.BdExpandListView.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void le() {
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
        azVar = this.cei.bOU;
        if (azVar != null) {
            azVar10 = this.cei.bOU;
            if (azVar10.Lc() != null) {
                azVar11 = this.cei.bOU;
                azVar11.Lc().amG();
            }
        }
        cc.TV().cZ(false);
        frsActivity = this.cei.bVk;
        com.baidu.tieba.tbadkCore.n aas = frsActivity.aas();
        azVar2 = this.cei.bOU;
        if (azVar2 != null && aas != null) {
            frsModelController = this.cei.bPf;
            if (frsModelController != null) {
                if (com.baidu.adp.lib.util.i.hk()) {
                    azVar5 = this.cei.bOU;
                    if (azVar5.aaL() instanceof com.baidu.tieba.frs.tab.h) {
                        azVar6 = this.cei.bOU;
                        if (azVar6.getListView() instanceof BdExpandListView) {
                            azVar9 = this.cei.bOU;
                        }
                        azVar7 = this.cei.bOU;
                        ((com.baidu.tieba.frs.tab.h) azVar7.aaL()).lc();
                        azVar8 = this.cei.bOU;
                        azVar8.cg(true);
                    }
                    frsActivity4 = this.cei.bVk;
                    TiebaStatic.eventStat(frsActivity4.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                    if (aas.aKx() != null && aas.fvK == 1) {
                        frsModelController2 = this.cei.bPf;
                        com.baidu.tieba.frs.e.b.a(aas, frsModelController2.adS(), 1);
                    }
                    frsActivity5 = this.cei.bVk;
                    frsActivity5.refresh();
                } else {
                    azVar3 = this.cei.bOU;
                    if (azVar3.aaL() instanceof com.baidu.tieba.frs.tab.h) {
                        azVar4 = this.cei.bOU;
                        ((com.baidu.tieba.frs.tab.h) azVar4.aaL()).aet();
                    }
                }
                com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11749");
                frsActivity2 = this.cei.bVk;
                com.baidu.tbadk.core.util.as aa = asVar.aa("fid", frsActivity2.getFid());
                frsActivity3 = this.cei.bVk;
                TiebaStatic.log(aa.aa("obj_locate", frsActivity3.aai() ? "2" : "1"));
            }
        }
    }
}
