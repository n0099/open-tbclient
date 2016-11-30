package com.baidu.tieba.frs.j;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements BdExpandListView.a {
    final /* synthetic */ y ckm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(y yVar) {
        this.ckm = yVar;
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void G(float f) {
        au auVar;
        au auVar2;
        au auVar3;
        auVar = this.ckm.bRW;
        if (auVar != null) {
            auVar2 = this.ckm.bRW;
            if (auVar2.acJ() instanceof com.baidu.tieba.frs.tab.h) {
                auVar3 = this.ckm.bRW;
                ((com.baidu.tieba.frs.tab.h) auVar3.acJ()).F(f);
            }
        }
    }

    @Override // com.baidu.tieba.view.BdExpandListView.a
    public void ki() {
        au auVar;
        au auVar2;
        au auVar3;
        auVar = this.ckm.bRW;
        if (auVar != null) {
            auVar2 = this.ckm.bRW;
            if (auVar2.acJ() instanceof com.baidu.tieba.frs.tab.h) {
                auVar3 = this.ckm.bRW;
                ((com.baidu.tieba.frs.tab.h) auVar3.acJ()).agY();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (((com.baidu.tieba.view.BdExpandListView) r0.acW()).blo() == false) goto L20;
     */
    @Override // com.baidu.tieba.view.BdExpandListView.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void kj() {
        au auVar;
        FrsActivity frsActivity;
        au auVar2;
        com.baidu.tieba.frs.e.i iVar;
        au auVar3;
        au auVar4;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        au auVar5;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        com.baidu.tieba.frs.e.i iVar2;
        au auVar6;
        au auVar7;
        au auVar8;
        au auVar9;
        au auVar10;
        au auVar11;
        auVar = this.ckm.bRW;
        if (auVar != null) {
            auVar10 = this.ckm.bRW;
            if (auVar10.Kp() != null) {
                auVar11 = this.ckm.bRW;
                auVar11.Kp().aro();
            }
        }
        bx.Pl().cx(false);
        frsActivity = this.ckm.bZY;
        com.baidu.tieba.tbadkCore.p acr = frsActivity.acr();
        auVar2 = this.ckm.bRW;
        if (auVar2 != null && acr != null) {
            iVar = this.ckm.bSh;
            if (iVar != null) {
                if (com.baidu.adp.lib.util.i.gm()) {
                    auVar5 = this.ckm.bRW;
                    if (auVar5.acJ() instanceof com.baidu.tieba.frs.tab.h) {
                        auVar6 = this.ckm.bRW;
                        if (auVar6.acW() instanceof BdExpandListView) {
                            auVar9 = this.ckm.bRW;
                        }
                        auVar7 = this.ckm.bRW;
                        ((com.baidu.tieba.frs.tab.h) auVar7.acJ()).kh();
                        auVar8 = this.ckm.bRW;
                        auVar8.dO(true);
                    }
                    frsActivity4 = this.ckm.bZY;
                    TiebaStatic.eventStat(frsActivity4.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                    if (acr.aOk() != null && acr.fzN == 1) {
                        iVar2 = this.ckm.bSh;
                        com.baidu.tieba.frs.h.b.a(acr, iVar2.agx(), 1);
                    }
                    frsActivity5 = this.ckm.bZY;
                    frsActivity5.refresh();
                } else {
                    auVar3 = this.ckm.bRW;
                    if (auVar3.acJ() instanceof com.baidu.tieba.frs.tab.h) {
                        auVar4 = this.ckm.bRW;
                        ((com.baidu.tieba.frs.tab.h) auVar4.acJ()).agY();
                    }
                }
                av avVar = new av("c11749");
                frsActivity2 = this.ckm.bZY;
                av ab = avVar.ab("fid", frsActivity2.getFid());
                frsActivity3 = this.ckm.bZY;
                TiebaStatic.log(ab.ab("obj_locate", frsActivity3.ach() ? "2" : "1"));
            }
        }
    }
}
