package com.baidu.tieba.frs.vc;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes6.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private j.b aEo;
    private j.a aEp;
    private j.c aEq;
    private com.baidu.tieba.frs.smartsort.b dAB;
    private boolean dVT;
    private final CustomMessageListener dVU;
    private final BdExpandListView.a dVV;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.dVT = false;
        this.dVU = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dAn != null) {
                    h.this.dAn.startPullRefresh();
                }
            }
        };
        this.aEo = new j.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                if (h.this.dSg != null && h.this.dSg.isAdded()) {
                    h.this.dAn.cQ(true);
                    if (com.baidu.adp.lib.util.j.kX()) {
                        h.this.dSg.refresh();
                        if (h.this.dAn != null) {
                            h.this.dSg.gh(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dSg.azE();
                    }
                    TiebaStatic.log(new am("c11749").ax(ImageViewerConfig.FORUM_ID, h.this.dSg.getFid()).ax("obj_locate", "1"));
                }
            }
        };
        this.aEq = new j.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.j.c
            public void bq(boolean z) {
                h.this.dVT = true;
                if (h.this.dAn != null && h.this.dTe != null && h.this.dAy != null && h.this.dSg != null && h.this.dSg.isAdded()) {
                    if (h.this.dAn != null && h.this.dAn.aAq() != null) {
                        h.this.dAn.aAq().aLh();
                    }
                    h.this.dSg.gh(false);
                    com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dAn.aAe() != null && h.this.dTe != null && h.this.dAn.aAe().getVisibility() != 0) {
                                h.this.dTe.OL();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.aEp = new j.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (h.this.dSg != null && h.this.dSg.isAdded()) {
                    if (h.this.dVT && h.this.dSg.azz() != null) {
                        h.this.dSg.azz().aGp();
                        h.this.dVT = false;
                    }
                    if (h.this.dAB != null && h.this.dSg.azB() != null && h.this.dSg.azB().aAs() != null && !h.this.dSg.azB().aAs().aCW()) {
                        h.this.dAB.aFA();
                    }
                    if (h.this.dAn != null && h.this.dTe != null && h.this.dAy != null && h.this.dAB != null) {
                        h.this.dAn.aAq().b(0, 0, true, true);
                        h.this.dSg.azI();
                        h.this.dSg.gh(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dSg.azB() != null) {
                            h.this.dSg.azB().cQ(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dSg.Eg().getVisibility() != 0 || v.J(h.this.dSg.azS().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dVV = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void N(float f) {
                if (h.this.dAn != null && (h.this.dAn.aAr() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dAn.aAr()).M(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void oF() {
                if (h.this.dAn != null && (h.this.dAn.aAr() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dAn.aAr()).aFG();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.dAn != null && h.this.dAn.aAq() != null) {
                    h.this.dAn.aAq().aLh();
                }
                com.baidu.tieba.card.v.aop().fh(false);
                l azS = h.this.dSg.azS();
                if (h.this.dAn != null && azS != null && h.this.dAx != null) {
                    if (com.baidu.adp.lib.util.j.kX()) {
                        if (h.this.dAn.aAr() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!azS.bBk()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.dAn.aAr()).oE();
                            }
                            h.this.dAn.cQ(true);
                        }
                        TiebaStatic.eventStat(h.this.dSg.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (azS.beT() != null && azS.haj == 1) {
                            com.baidu.tieba.frs.e.b.a(azS, h.this.dAx.aFk(), 1);
                        }
                        h.this.dSg.refresh();
                    } else if (h.this.dAn.aAr() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.dAn.aAr()).aFG();
                    }
                    TiebaStatic.log(new am("c11749").ax(ImageViewerConfig.FORUM_ID, h.this.dSg.getFid()).ax("obj_locate", "1"));
                }
            }
        };
        this.dAB = frsFragment.azv();
        frsFragment.registerListener(this.dVU);
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            kVar.gu(z);
            kVar.a(this.aEo);
            kVar.a(this.aEq);
            kVar.a(this.aEp);
        }
    }
}
