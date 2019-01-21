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
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes6.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private j.b aJi;
    private j.a aJj;
    private j.c aJk;
    private com.baidu.tieba.frs.smartsort.b dLP;
    private boolean ehb;
    private final CustomMessageListener ehc;
    private final BdExpandListView.a ehd;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.ehb = false;
        this.ehc = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dLB != null) {
                    h.this.dLB.startPullRefresh();
                }
            }
        };
        this.aJi = new j.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                if (h.this.edn != null && h.this.edn.isAdded()) {
                    h.this.dLB.dl(true);
                    if (com.baidu.adp.lib.util.j.kV()) {
                        h.this.edn.refresh();
                        if (h.this.dLB != null) {
                            h.this.edn.gy(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.edn.aBX();
                    }
                    TiebaStatic.log(new am("c11749").aB(ImageViewerConfig.FORUM_ID, h.this.edn.getFid()).aB("obj_locate", "1"));
                }
            }
        };
        this.aJk = new j.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.j.c
            public void bJ(boolean z) {
                h.this.ehb = true;
                if (h.this.dLB != null && h.this.eel != null && h.this.dLM != null && h.this.edn != null && h.this.edn.isAdded()) {
                    if (h.this.dLB != null && h.this.dLB.aCJ() != null) {
                        h.this.dLB.aCJ().aNK();
                    }
                    h.this.edn.gy(false);
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dLB.aCy() != null && h.this.eel != null && h.this.dLB.aCy().getVisibility() != 0) {
                                h.this.eel.Qx();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.aJj = new j.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (h.this.edn != null && h.this.edn.isAdded()) {
                    if (h.this.ehb && h.this.edn.aBS() != null) {
                        h.this.edn.aBS().aIJ();
                        h.this.ehb = false;
                    }
                    if (h.this.dLP != null && h.this.edn.aBU() != null && h.this.edn.aBU().aCL() != null && !h.this.edn.aBU().aCL().aFo()) {
                        h.this.dLP.aHU();
                    }
                    if (h.this.dLB != null && h.this.eel != null && h.this.dLM != null && h.this.dLP != null) {
                        h.this.dLB.aCJ().b(0, 0, true, true);
                        h.this.edn.aCb();
                        h.this.edn.gy(true);
                        h.this.edn.gv(false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.edn.aBU() != null) {
                            h.this.edn.aBU().dl(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.edn.FI().getVisibility() != 0 || v.I(h.this.edn.aCl().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.ehd = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void N(float f) {
                if (h.this.dLB != null && (h.this.dLB.aCK() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dLB.aCK()).M(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void oG() {
                if (h.this.dLB != null && (h.this.dLB.aCK() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dLB.aCK()).aIa();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.dLB != null && h.this.dLB.aCJ() != null) {
                    h.this.dLB.aCJ().aNK();
                }
                com.baidu.tieba.card.v.aqP().fy(false);
                l aCl = h.this.edn.aCl();
                if (h.this.dLB != null && aCl != null && h.this.dLL != null) {
                    if (com.baidu.adp.lib.util.j.kV()) {
                        if (h.this.dLB.aCK() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!aCl.bEb()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.dLB.aCK()).oF();
                            }
                            h.this.dLB.dl(true);
                        }
                        TiebaStatic.eventStat(h.this.edn.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (aCl.bhx() != null && aCl.hmQ == 1) {
                            com.baidu.tieba.frs.e.c.a(aCl, h.this.dLL.aHE(), 1);
                        }
                        h.this.edn.refresh();
                    } else if (h.this.dLB.aCK() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.dLB.aCK()).aIa();
                    }
                    TiebaStatic.log(new am("c11749").aB(ImageViewerConfig.FORUM_ID, h.this.edn.getFid()).aB("obj_locate", "1"));
                }
            }
        };
        this.dLP = frsFragment.aBO();
        frsFragment.registerListener(this.ehc);
    }

    public void c(com.baidu.tieba.frs.k kVar, boolean z) {
        if (kVar != null) {
            kVar.gL(z);
            kVar.a(this.aJi);
            kVar.a(this.aJk);
            kVar.a(this.aJj);
        }
    }
}
