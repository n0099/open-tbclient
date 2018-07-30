package com.baidu.tieba.frs.vc;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.card.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private g.b aww;
    private g.a awx;
    private g.c awy;
    private boolean dGU;
    private final CustomMessageListener dGV;
    private final BdExpandListView.a dGW;
    private com.baidu.tieba.frs.smartsort.b dmF;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.dGU = false;
        this.dGV = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dmq != null) {
                    h.this.dmq.startPullRefresh();
                }
            }
        };
        this.aww = new g.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                if (h.this.dDw != null && h.this.dDw.isAdded()) {
                    h.this.dmq.cp(true);
                    if (com.baidu.adp.lib.util.j.jE()) {
                        h.this.dDw.refresh();
                        if (h.this.dmq != null) {
                            h.this.dDw.fy(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dDw.aup();
                    }
                    TiebaStatic.log(new an("c11749").af(ImageViewerConfig.FORUM_ID, h.this.dDw.getFid()).af("obj_locate", "1"));
                }
            }
        };
        this.awy = new g.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.g.c
            public void aT(boolean z) {
                h.this.dGU = true;
                if (h.this.dmq != null && h.this.dEu != null && h.this.dmC != null && h.this.dDw != null && h.this.dDw.isAdded()) {
                    if (h.this.dmq != null && h.this.dmq.avc() != null) {
                        h.this.dmq.avc().aFD();
                    }
                    h.this.dDw.fy(false);
                    com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dmq.auP() != null && h.this.dEu != null && h.this.dmq.auP().getVisibility() != 0) {
                                h.this.dEu.Lr();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.awx = new g.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (h.this.dDw != null && h.this.dDw.isAdded()) {
                    if (h.this.dGU && h.this.dDw.auk() != null) {
                        h.this.dDw.auk().aAQ();
                        h.this.dGU = false;
                    }
                    if (h.this.dmF != null && h.this.dDw.aum() != null && h.this.dDw.aum().ave() != null && !h.this.dDw.aum().ave().axq()) {
                        h.this.dmF.aAb();
                    }
                    if (h.this.dmq != null && h.this.dEu != null && h.this.dmC != null && h.this.dmF != null) {
                        h.this.dmq.avc().b(0, 0, true, true);
                        h.this.dDw.aut();
                        h.this.dDw.fy(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dDw.aum() != null) {
                            h.this.dDw.aum().cp(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dDw.AS().getVisibility() != 0 || w.z(h.this.dDw.auD().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dGW = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void N(float f) {
                if (h.this.dmq != null && (h.this.dmq.avd() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dmq.avd()).M(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void no() {
                if (h.this.dmq != null && (h.this.dmq.avd() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dmq.avd()).aAh();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.dmq != null && h.this.dmq.avc() != null) {
                    h.this.dmq.avc().aFD();
                }
                v.aiY().ey(false);
                l auD = h.this.dDw.auD();
                if (h.this.dmq != null && auD != null && h.this.dmB != null) {
                    if (com.baidu.adp.lib.util.j.jE()) {
                        if (h.this.dmq.avd() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!auD.bvo()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.dmq.avd()).nn();
                            }
                            h.this.dmq.cp(true);
                        }
                        TiebaStatic.eventStat(h.this.dDw.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (auD.aZl() != null && auD.gLj == 1) {
                            com.baidu.tieba.frs.e.b.a(auD, h.this.dmB.azL(), 1);
                        }
                        h.this.dDw.refresh();
                    } else if (h.this.dmq.avd() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.dmq.avd()).aAh();
                    }
                    TiebaStatic.log(new an("c11749").af(ImageViewerConfig.FORUM_ID, h.this.dDw.getFid()).af("obj_locate", "1"));
                }
            }
        };
        this.dmF = frsFragment.aug();
        frsFragment.registerListener(this.dGV);
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            kVar.fL(z);
            kVar.a(this.aww);
            kVar.a(this.awy);
            kVar.a(this.awx);
        }
    }
}
