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
    private j.b aJh;
    private j.a aJi;
    private j.c aJj;
    private com.baidu.tieba.frs.smartsort.b dLO;
    private boolean eha;
    private final CustomMessageListener ehb;
    private final BdExpandListView.a ehc;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.eha = false;
        this.ehb = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dLA != null) {
                    h.this.dLA.startPullRefresh();
                }
            }
        };
        this.aJh = new j.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                if (h.this.edm != null && h.this.edm.isAdded()) {
                    h.this.dLA.dl(true);
                    if (com.baidu.adp.lib.util.j.kV()) {
                        h.this.edm.refresh();
                        if (h.this.dLA != null) {
                            h.this.edm.gy(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.edm.aBX();
                    }
                    TiebaStatic.log(new am("c11749").aB(ImageViewerConfig.FORUM_ID, h.this.edm.getFid()).aB("obj_locate", "1"));
                }
            }
        };
        this.aJj = new j.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.j.c
            public void bJ(boolean z) {
                h.this.eha = true;
                if (h.this.dLA != null && h.this.eek != null && h.this.dLL != null && h.this.edm != null && h.this.edm.isAdded()) {
                    if (h.this.dLA != null && h.this.dLA.aCJ() != null) {
                        h.this.dLA.aCJ().aNK();
                    }
                    h.this.edm.gy(false);
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dLA.aCy() != null && h.this.eek != null && h.this.dLA.aCy().getVisibility() != 0) {
                                h.this.eek.Qx();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.aJi = new j.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (h.this.edm != null && h.this.edm.isAdded()) {
                    if (h.this.eha && h.this.edm.aBS() != null) {
                        h.this.edm.aBS().aIJ();
                        h.this.eha = false;
                    }
                    if (h.this.dLO != null && h.this.edm.aBU() != null && h.this.edm.aBU().aCL() != null && !h.this.edm.aBU().aCL().aFo()) {
                        h.this.dLO.aHU();
                    }
                    if (h.this.dLA != null && h.this.eek != null && h.this.dLL != null && h.this.dLO != null) {
                        h.this.dLA.aCJ().b(0, 0, true, true);
                        h.this.edm.aCb();
                        h.this.edm.gy(true);
                        h.this.edm.gv(false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.edm.aBU() != null) {
                            h.this.edm.aBU().dl(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.edm.FI().getVisibility() != 0 || v.I(h.this.edm.aCl().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.ehc = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void N(float f) {
                if (h.this.dLA != null && (h.this.dLA.aCK() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dLA.aCK()).M(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void oG() {
                if (h.this.dLA != null && (h.this.dLA.aCK() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dLA.aCK()).aIa();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.dLA != null && h.this.dLA.aCJ() != null) {
                    h.this.dLA.aCJ().aNK();
                }
                com.baidu.tieba.card.v.aqP().fy(false);
                l aCl = h.this.edm.aCl();
                if (h.this.dLA != null && aCl != null && h.this.dLK != null) {
                    if (com.baidu.adp.lib.util.j.kV()) {
                        if (h.this.dLA.aCK() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!aCl.bEb()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.dLA.aCK()).oF();
                            }
                            h.this.dLA.dl(true);
                        }
                        TiebaStatic.eventStat(h.this.edm.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (aCl.bhx() != null && aCl.hmP == 1) {
                            com.baidu.tieba.frs.e.c.a(aCl, h.this.dLK.aHE(), 1);
                        }
                        h.this.edm.refresh();
                    } else if (h.this.dLA.aCK() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.dLA.aCK()).aIa();
                    }
                    TiebaStatic.log(new am("c11749").aB(ImageViewerConfig.FORUM_ID, h.this.edm.getFid()).aB("obj_locate", "1"));
                }
            }
        };
        this.dLO = frsFragment.aBO();
        frsFragment.registerListener(this.ehb);
    }

    public void c(com.baidu.tieba.frs.k kVar, boolean z) {
        if (kVar != null) {
            kVar.gL(z);
            kVar.a(this.aJh);
            kVar.a(this.aJj);
            kVar.a(this.aJi);
        }
    }
}
