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
    private boolean dVS;
    private final CustomMessageListener dVT;
    private final BdExpandListView.a dVU;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.dVS = false;
        this.dVT = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
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
                if (h.this.dSf != null && h.this.dSf.isAdded()) {
                    h.this.dAn.cQ(true);
                    if (com.baidu.adp.lib.util.j.kX()) {
                        h.this.dSf.refresh();
                        if (h.this.dAn != null) {
                            h.this.dSf.gh(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dSf.azD();
                    }
                    TiebaStatic.log(new am("c11749").ax(ImageViewerConfig.FORUM_ID, h.this.dSf.getFid()).ax("obj_locate", "1"));
                }
            }
        };
        this.aEq = new j.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.j.c
            public void bq(boolean z) {
                h.this.dVS = true;
                if (h.this.dAn != null && h.this.dTd != null && h.this.dAy != null && h.this.dSf != null && h.this.dSf.isAdded()) {
                    if (h.this.dAn != null && h.this.dAn.aAp() != null) {
                        h.this.dAn.aAp().aLh();
                    }
                    h.this.dSf.gh(false);
                    com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dAn.aAd() != null && h.this.dTd != null && h.this.dAn.aAd().getVisibility() != 0) {
                                h.this.dTd.OL();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.aEp = new j.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (h.this.dSf != null && h.this.dSf.isAdded()) {
                    if (h.this.dVS && h.this.dSf.azy() != null) {
                        h.this.dSf.azy().aGp();
                        h.this.dVS = false;
                    }
                    if (h.this.dAB != null && h.this.dSf.azA() != null && h.this.dSf.azA().aAr() != null && !h.this.dSf.azA().aAr().aCV()) {
                        h.this.dAB.aFA();
                    }
                    if (h.this.dAn != null && h.this.dTd != null && h.this.dAy != null && h.this.dAB != null) {
                        h.this.dAn.aAp().b(0, 0, true, true);
                        h.this.dSf.azH();
                        h.this.dSf.gh(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dSf.azA() != null) {
                            h.this.dSf.azA().cQ(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dSf.Eg().getVisibility() != 0 || v.J(h.this.dSf.azR().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dVU = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void N(float f) {
                if (h.this.dAn != null && (h.this.dAn.aAq() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dAn.aAq()).M(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void oF() {
                if (h.this.dAn != null && (h.this.dAn.aAq() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dAn.aAq()).aFG();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.dAn != null && h.this.dAn.aAp() != null) {
                    h.this.dAn.aAp().aLh();
                }
                com.baidu.tieba.card.v.aoo().fh(false);
                l azR = h.this.dSf.azR();
                if (h.this.dAn != null && azR != null && h.this.dAx != null) {
                    if (com.baidu.adp.lib.util.j.kX()) {
                        if (h.this.dAn.aAq() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!azR.bBk()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.dAn.aAq()).oE();
                            }
                            h.this.dAn.cQ(true);
                        }
                        TiebaStatic.eventStat(h.this.dSf.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (azR.beT() != null && azR.hai == 1) {
                            com.baidu.tieba.frs.e.b.a(azR, h.this.dAx.aFk(), 1);
                        }
                        h.this.dSf.refresh();
                    } else if (h.this.dAn.aAq() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.dAn.aAq()).aFG();
                    }
                    TiebaStatic.log(new am("c11749").ax(ImageViewerConfig.FORUM_ID, h.this.dSf.getFid()).ax("obj_locate", "1"));
                }
            }
        };
        this.dAB = frsFragment.azu();
        frsFragment.registerListener(this.dVT);
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
