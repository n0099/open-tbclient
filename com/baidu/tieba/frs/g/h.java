package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.card.r;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.view.a;
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private j.b bcR;
    private j.a bcS;
    private j.c bcT;
    private com.baidu.tieba.frs.smartsort.b dEJ;
    private boolean dVK;
    private final CustomMessageListener dVL;
    private final a.InterfaceC0249a dVM;

    public h(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dVK = false;
        this.dVL = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.g.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dEx != null) {
                    h.this.dEx.startPullRefresh();
                }
            }
        };
        this.bcR = new j.b() { // from class: com.baidu.tieba.frs.g.h.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (h.this.dSV != null && h.this.dSV.isAdded()) {
                    h.this.dEx.cQ(true);
                    if (com.baidu.adp.lib.util.j.oJ()) {
                        h.this.dSV.refresh();
                        if (h.this.dEx != null) {
                            h.this.dSV.fK(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dSV.auW();
                    }
                    TiebaStatic.log(new ak("c11749").ab(ImageViewerConfig.FORUM_ID, h.this.dSV.getFid()).ab("obj_locate", "1"));
                }
            }
        };
        this.bcT = new j.c() { // from class: com.baidu.tieba.frs.g.h.3
            @Override // com.baidu.tbadk.core.view.j.c
            public void bx(boolean z) {
                h.this.dVK = true;
                if (h.this.dEx != null && h.this.dTQ != null && h.this.dEG != null && h.this.dSV != null && h.this.dSV.isAdded()) {
                    if (h.this.dEx != null && h.this.dEx.avE() != null) {
                        h.this.dEx.avE().aEa();
                    }
                    h.this.dSV.fK(false);
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dEx.avr() != null && h.this.dTQ != null && h.this.dEx.avr().getVisibility() != 0) {
                                h.this.dTQ.Pi();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.bcS = new j.a() { // from class: com.baidu.tieba.frs.g.h.4
            @Override // com.baidu.tbadk.core.view.j.a
            public void i(View view, boolean z) {
                if (h.this.dSV != null && h.this.dSV.isAdded()) {
                    if (h.this.dVK && h.this.dSV.auR() != null) {
                        h.this.dSV.auR().aAx();
                        h.this.dVK = false;
                    }
                    if (h.this.dEJ != null && h.this.dSV.auT() != null && h.this.dSV.auT().avG() != null && !h.this.dSV.auT().avG().axE()) {
                        h.this.dEJ.azL();
                    }
                    if (h.this.dEx != null && h.this.dTQ != null && h.this.dEG != null && h.this.dEJ != null) {
                        h.this.dSV.ava();
                        h.this.dSV.fK(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dSV.auT() != null) {
                            h.this.dSV.auT().cQ(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dSV.Ez().getVisibility() != 0 || v.E(h.this.dSV.avl().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dVM = new a.InterfaceC0249a() { // from class: com.baidu.tieba.frs.g.h.5
            @Override // com.baidu.tieba.view.a.InterfaceC0249a
            public void P(float f) {
                if (h.this.dEx != null && (h.this.dEx.avF() instanceof com.baidu.tieba.frs.tab.a)) {
                    ((com.baidu.tieba.frs.tab.a) h.this.dEx.avF()).O(f);
                }
            }

            @Override // com.baidu.tieba.view.a.InterfaceC0249a
            public void ss() {
                if (h.this.dEx != null && (h.this.dEx.avF() instanceof com.baidu.tieba.frs.tab.a)) {
                    ((com.baidu.tieba.frs.tab.a) h.this.dEx.avF()).azT();
                }
            }

            @Override // com.baidu.tieba.view.a.InterfaceC0249a
            public void onRefresh() {
                if (h.this.dEx != null && h.this.dEx.avE() != null) {
                    h.this.dEx.avE().aEa();
                }
                r.alt().eO(false);
                l avl = h.this.dSV.avl();
                if (h.this.dEx != null && avl != null && h.this.dEF != null) {
                    if (com.baidu.adp.lib.util.j.oJ()) {
                        if (h.this.dEx.avF() instanceof com.baidu.tieba.frs.tab.a) {
                            if (!avl.bwf()) {
                                ((com.baidu.tieba.frs.tab.a) h.this.dEx.avF()).sr();
                            }
                            h.this.dEx.cQ(true);
                        }
                        TiebaStatic.eventStat(h.this.dSV.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (avl.bas() != null && avl.gYp == 1) {
                            com.baidu.tieba.frs.e.b.a(avl, h.this.dEF.azx(), 1);
                        }
                        h.this.dSV.refresh();
                    } else if (h.this.dEx.avF() instanceof com.baidu.tieba.frs.tab.a) {
                        ((com.baidu.tieba.frs.tab.a) h.this.dEx.avF()).azT();
                    }
                    TiebaStatic.log(new ak("c11749").ab(ImageViewerConfig.FORUM_ID, h.this.dSV.getFid()).ab("obj_locate", "1"));
                }
            }
        };
        this.dEJ = iVar.auN();
        iVar.registerListener(this.dVL);
    }

    public void c(com.baidu.tieba.frs.k kVar, boolean z) {
        if (kVar != null) {
            kVar.fU(z);
            kVar.a(this.bcR);
            kVar.a(this.bcT);
            kVar.a(this.bcS);
        }
    }
}
