package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements BdExpandListView.a {
    final /* synthetic */ ag cif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ag agVar) {
        this.cif = agVar;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void G(float f) {
        au auVar;
        au auVar2;
        au auVar3;
        auVar = this.cif.bUa;
        if (auVar != null) {
            auVar2 = this.cif.bUa;
            if (auVar2.aaD() instanceof com.baidu.tieba.frs.tab.i) {
                auVar3 = this.cif.bUa;
                ((com.baidu.tieba.frs.tab.i) auVar3.aaD()).F(f);
            }
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void lc() {
        au auVar;
        au auVar2;
        au auVar3;
        auVar = this.cif.bUa;
        if (auVar != null) {
            auVar2 = this.cif.bUa;
            if (auVar2.aaD() instanceof com.baidu.tieba.frs.tab.i) {
                auVar3 = this.cif.bUa;
                ((com.baidu.tieba.frs.tab.i) auVar3.aaD()).Tx();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (((com.baidu.tieba.view.BdExpandListView) r0.getListView()).bhm() == false) goto L20;
     */
    @Override // com.baidu.tieba.view.BdExpandListView.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ld() {
        au auVar;
        com.baidu.tieba.frs.r rVar;
        au auVar2;
        FrsModelController frsModelController;
        au auVar3;
        au auVar4;
        com.baidu.tieba.frs.r rVar2;
        au auVar5;
        com.baidu.tieba.frs.r rVar3;
        com.baidu.tieba.frs.r rVar4;
        FrsModelController frsModelController2;
        au auVar6;
        au auVar7;
        au auVar8;
        au auVar9;
        au auVar10;
        au auVar11;
        auVar = this.cif.bUa;
        if (auVar != null) {
            auVar10 = this.cif.bUa;
            if (auVar10.aaC() != null) {
                auVar11 = this.cif.bUa;
                auVar11.aaC().akv();
            }
        }
        cf.Uw().dt(false);
        rVar = this.cif.bTw;
        com.baidu.tieba.tbadkCore.n aau = rVar.aau();
        auVar2 = this.cif.bUa;
        if (auVar2 != null && aau != null) {
            frsModelController = this.cif.bUj;
            if (frsModelController != null) {
                if (com.baidu.adp.lib.util.i.hk()) {
                    auVar5 = this.cif.bUa;
                    if (auVar5.aaD() instanceof com.baidu.tieba.frs.tab.i) {
                        auVar6 = this.cif.bUa;
                        if (auVar6.getListView() instanceof BdExpandListView) {
                            auVar9 = this.cif.bUa;
                        }
                        auVar7 = this.cif.bUa;
                        ((com.baidu.tieba.frs.tab.i) auVar7.aaD()).lb();
                        auVar8 = this.cif.bUa;
                        auVar8.cf(true);
                    }
                    rVar3 = this.cif.bTw;
                    TiebaStatic.eventStat(rVar3.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                    if (aau.aIz() != null && aau.fzF == 1) {
                        frsModelController2 = this.cif.bUj;
                        com.baidu.tieba.frs.d.b.a(aau, frsModelController2.ada(), 1);
                    }
                    rVar4 = this.cif.bTw;
                    rVar4.refresh();
                } else {
                    auVar3 = this.cif.bUa;
                    if (auVar3.aaD() instanceof com.baidu.tieba.frs.tab.i) {
                        auVar4 = this.cif.bUa;
                        ((com.baidu.tieba.frs.tab.i) auVar4.aaD()).Tx();
                    }
                }
                as asVar = new as("c11749");
                rVar2 = this.cif.bTw;
                TiebaStatic.log(asVar.Z("fid", rVar2.getFid()).Z("obj_locate", "1"));
            }
        }
    }
}
