package com.baidu.tieba.frs.f;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements BdExpandListView.a {
    final /* synthetic */ x cqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar) {
        this.cqf = xVar;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void G(float f) {
        av avVar;
        av avVar2;
        av avVar3;
        avVar = this.cqf.ccj;
        if (avVar != null) {
            avVar2 = this.cqf.ccj;
            if (avVar2.aet() instanceof com.baidu.tieba.frs.tab.i) {
                avVar3 = this.cqf.ccj;
                ((com.baidu.tieba.frs.tab.i) avVar3.aet()).F(f);
            }
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void la() {
        av avVar;
        av avVar2;
        av avVar3;
        avVar = this.cqf.ccj;
        if (avVar != null) {
            avVar2 = this.cqf.ccj;
            if (avVar2.aet() instanceof com.baidu.tieba.frs.tab.i) {
                avVar3 = this.cqf.ccj;
                ((com.baidu.tieba.frs.tab.i) avVar3.aet()).ahs();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (((com.baidu.tieba.view.BdExpandListView) r0.getListView()).blA() == false) goto L20;
     */
    @Override // com.baidu.tieba.view.BdExpandListView.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void lb() {
        av avVar;
        com.baidu.tieba.frs.r rVar;
        av avVar2;
        FrsModelController frsModelController;
        av avVar3;
        av avVar4;
        com.baidu.tieba.frs.r rVar2;
        av avVar5;
        com.baidu.tieba.frs.r rVar3;
        com.baidu.tieba.frs.r rVar4;
        FrsModelController frsModelController2;
        av avVar6;
        av avVar7;
        av avVar8;
        av avVar9;
        av avVar10;
        av avVar11;
        avVar = this.cqf.ccj;
        if (avVar != null) {
            avVar10 = this.cqf.ccj;
            if (avVar10.aes() != null) {
                avVar11 = this.cqf.ccj;
                avVar11.aes().aog();
            }
        }
        cf.VN().dv(false);
        rVar = this.cqf.cbE;
        com.baidu.tieba.tbadkCore.n aek = rVar.aek();
        avVar2 = this.cqf.ccj;
        if (avVar2 != null && aek != null) {
            frsModelController = this.cqf.ccs;
            if (frsModelController != null) {
                if (com.baidu.adp.lib.util.i.hj()) {
                    avVar5 = this.cqf.ccj;
                    if (avVar5.aet() instanceof com.baidu.tieba.frs.tab.i) {
                        avVar6 = this.cqf.ccj;
                        if (avVar6.getListView() instanceof BdExpandListView) {
                            avVar9 = this.cqf.ccj;
                        }
                        avVar7 = this.cqf.ccj;
                        ((com.baidu.tieba.frs.tab.i) avVar7.aet()).kZ();
                        avVar8 = this.cqf.ccj;
                        avVar8.ch(true);
                    }
                    rVar3 = this.cqf.cbE;
                    TiebaStatic.eventStat(rVar3.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                    if (aek.aMt() != null && aek.fJJ == 1) {
                        frsModelController2 = this.cqf.ccs;
                        com.baidu.tieba.frs.d.b.a(aek, frsModelController2.agT(), 1);
                    }
                    rVar4 = this.cqf.cbE;
                    rVar4.refresh();
                } else {
                    avVar3 = this.cqf.ccj;
                    if (avVar3.aet() instanceof com.baidu.tieba.frs.tab.i) {
                        avVar4 = this.cqf.ccj;
                        ((com.baidu.tieba.frs.tab.i) avVar4.aet()).ahs();
                    }
                }
                au auVar = new au("c11749");
                rVar2 = this.cqf.cbE;
                TiebaStatic.log(auVar.Z("fid", rVar2.getFid()).Z("obj_locate", "1"));
            }
        }
    }
}
