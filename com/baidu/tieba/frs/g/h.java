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
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.view.a;
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private j.b bcH;
    private j.a bcI;
    private j.c bcJ;
    private com.baidu.tieba.frs.smartsort.b dEA;
    private boolean dVE;
    private final CustomMessageListener dVF;
    private final a.InterfaceC0250a dVG;

    public h(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dVE = false;
        this.dVF = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.g.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dEo != null) {
                    h.this.dEo.startPullRefresh();
                }
            }
        };
        this.bcH = new j.b() { // from class: com.baidu.tieba.frs.g.h.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (h.this.dSO != null && h.this.dSO.isAdded()) {
                    h.this.dEo.cQ(true);
                    if (com.baidu.adp.lib.util.j.oJ()) {
                        h.this.dSO.refresh();
                        if (h.this.dEo != null) {
                            h.this.dSO.fK(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dSO.auW();
                    }
                    TiebaStatic.log(new ak("c11749").ab(ImageViewerConfig.FORUM_ID, h.this.dSO.getFid()).ab("obj_locate", "1"));
                }
            }
        };
        this.bcJ = new j.c() { // from class: com.baidu.tieba.frs.g.h.3
            @Override // com.baidu.tbadk.core.view.j.c
            public void bx(boolean z) {
                h.this.dVE = true;
                if (h.this.dEo != null && h.this.dTJ != null && h.this.dEx != null && h.this.dSO != null && h.this.dSO.isAdded()) {
                    if (h.this.dEo != null && h.this.dEo.avF() != null) {
                        h.this.dEo.avF().aEa();
                    }
                    h.this.dSO.fK(false);
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dEo.avr() != null && h.this.dTJ != null && h.this.dEo.avr().getVisibility() != 0) {
                                h.this.dTJ.Pi();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.bcI = new j.a() { // from class: com.baidu.tieba.frs.g.h.4
            @Override // com.baidu.tbadk.core.view.j.a
            public void i(View view, boolean z) {
                if (h.this.dSO != null && h.this.dSO.isAdded()) {
                    if (h.this.dVE && h.this.dSO.auR() != null) {
                        h.this.dSO.auR().aAy();
                        h.this.dVE = false;
                    }
                    if (h.this.dEA != null && h.this.dSO.auT() != null && h.this.dSO.auT().avH() != null && !h.this.dSO.auT().avH().axF()) {
                        h.this.dEA.azM();
                    }
                    if (h.this.dEo != null && h.this.dTJ != null && h.this.dEx != null && h.this.dEA != null) {
                        h.this.dSO.ava();
                        h.this.dSO.fK(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dSO.auT() != null) {
                            h.this.dSO.auT().cQ(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dSO.Ez().getVisibility() != 0 || v.E(h.this.dSO.avl().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dVG = new a.InterfaceC0250a() { // from class: com.baidu.tieba.frs.g.h.5
            @Override // com.baidu.tieba.view.a.InterfaceC0250a
            public void P(float f) {
                if (h.this.dEo != null && (h.this.dEo.avG() instanceof com.baidu.tieba.frs.tab.a)) {
                    ((com.baidu.tieba.frs.tab.a) h.this.dEo.avG()).O(f);
                }
            }

            @Override // com.baidu.tieba.view.a.InterfaceC0250a
            public void ss() {
                if (h.this.dEo != null && (h.this.dEo.avG() instanceof com.baidu.tieba.frs.tab.a)) {
                    ((com.baidu.tieba.frs.tab.a) h.this.dEo.avG()).azU();
                }
            }

            @Override // com.baidu.tieba.view.a.InterfaceC0250a
            public void onRefresh() {
                if (h.this.dEo != null && h.this.dEo.avF() != null) {
                    h.this.dEo.avF().aEa();
                }
                r.alt().eO(false);
                m avl = h.this.dSO.avl();
                if (h.this.dEo != null && avl != null && h.this.dEw != null) {
                    if (com.baidu.adp.lib.util.j.oJ()) {
                        if (h.this.dEo.avG() instanceof com.baidu.tieba.frs.tab.a) {
                            if (!avl.bwj()) {
                                ((com.baidu.tieba.frs.tab.a) h.this.dEo.avG()).sr();
                            }
                            h.this.dEo.cQ(true);
                        }
                        TiebaStatic.eventStat(h.this.dSO.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (avl.bas() != null && avl.gYv == 1) {
                            com.baidu.tieba.frs.e.b.a(avl, h.this.dEw.azy(), 1);
                        }
                        h.this.dSO.refresh();
                    } else if (h.this.dEo.avG() instanceof com.baidu.tieba.frs.tab.a) {
                        ((com.baidu.tieba.frs.tab.a) h.this.dEo.avG()).azU();
                    }
                    TiebaStatic.log(new ak("c11749").ab(ImageViewerConfig.FORUM_ID, h.this.dSO.getFid()).ab("obj_locate", "1"));
                }
            }
        };
        this.dEA = iVar.auN();
        iVar.registerListener(this.dVF);
    }

    public void c(com.baidu.tieba.frs.k kVar, boolean z) {
        if (kVar != null) {
            kVar.fU(z);
            kVar.a(this.bcH);
            kVar.a(this.bcJ);
            kVar.a(this.bcI);
        }
    }
}
