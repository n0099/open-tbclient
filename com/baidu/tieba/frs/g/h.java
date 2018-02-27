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
    private j.b bcF;
    private j.a bcG;
    private j.c bcH;
    private com.baidu.tieba.frs.smartsort.b dEx;
    private final a.InterfaceC0250a dVA;
    private boolean dVy;
    private final CustomMessageListener dVz;

    public h(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dVy = false;
        this.dVz = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.g.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dEl != null) {
                    h.this.dEl.startPullRefresh();
                }
            }
        };
        this.bcF = new j.b() { // from class: com.baidu.tieba.frs.g.h.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (h.this.dSJ != null && h.this.dSJ.isAdded()) {
                    h.this.dEl.cQ(true);
                    if (com.baidu.adp.lib.util.j.oJ()) {
                        h.this.dSJ.refresh();
                        if (h.this.dEl != null) {
                            h.this.dSJ.fK(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dSJ.auV();
                    }
                    TiebaStatic.log(new ak("c11749").ab(ImageViewerConfig.FORUM_ID, h.this.dSJ.getFid()).ab("obj_locate", "1"));
                }
            }
        };
        this.bcH = new j.c() { // from class: com.baidu.tieba.frs.g.h.3
            @Override // com.baidu.tbadk.core.view.j.c
            public void bx(boolean z) {
                h.this.dVy = true;
                if (h.this.dEl != null && h.this.dTE != null && h.this.dEu != null && h.this.dSJ != null && h.this.dSJ.isAdded()) {
                    if (h.this.dEl != null && h.this.dEl.avD() != null) {
                        h.this.dEl.avD().aDZ();
                    }
                    h.this.dSJ.fK(false);
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dEl.avq() != null && h.this.dTE != null && h.this.dEl.avq().getVisibility() != 0) {
                                h.this.dTE.Ph();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.bcG = new j.a() { // from class: com.baidu.tieba.frs.g.h.4
            @Override // com.baidu.tbadk.core.view.j.a
            public void i(View view, boolean z) {
                if (h.this.dSJ != null && h.this.dSJ.isAdded()) {
                    if (h.this.dVy && h.this.dSJ.auQ() != null) {
                        h.this.dSJ.auQ().aAw();
                        h.this.dVy = false;
                    }
                    if (h.this.dEx != null && h.this.dSJ.auS() != null && h.this.dSJ.auS().avF() != null && !h.this.dSJ.auS().avF().axD()) {
                        h.this.dEx.azK();
                    }
                    if (h.this.dEl != null && h.this.dTE != null && h.this.dEu != null && h.this.dEx != null) {
                        h.this.dSJ.auZ();
                        h.this.dSJ.fK(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dSJ.auS() != null) {
                            h.this.dSJ.auS().cQ(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dSJ.Ey().getVisibility() != 0 || v.E(h.this.dSJ.avk().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dVA = new a.InterfaceC0250a() { // from class: com.baidu.tieba.frs.g.h.5
            @Override // com.baidu.tieba.view.a.InterfaceC0250a
            public void P(float f) {
                if (h.this.dEl != null && (h.this.dEl.avE() instanceof com.baidu.tieba.frs.tab.a)) {
                    ((com.baidu.tieba.frs.tab.a) h.this.dEl.avE()).O(f);
                }
            }

            @Override // com.baidu.tieba.view.a.InterfaceC0250a
            public void ss() {
                if (h.this.dEl != null && (h.this.dEl.avE() instanceof com.baidu.tieba.frs.tab.a)) {
                    ((com.baidu.tieba.frs.tab.a) h.this.dEl.avE()).azS();
                }
            }

            @Override // com.baidu.tieba.view.a.InterfaceC0250a
            public void onRefresh() {
                if (h.this.dEl != null && h.this.dEl.avD() != null) {
                    h.this.dEl.avD().aDZ();
                }
                r.als().eO(false);
                l avk = h.this.dSJ.avk();
                if (h.this.dEl != null && avk != null && h.this.dEt != null) {
                    if (com.baidu.adp.lib.util.j.oJ()) {
                        if (h.this.dEl.avE() instanceof com.baidu.tieba.frs.tab.a) {
                            if (!avk.bwe()) {
                                ((com.baidu.tieba.frs.tab.a) h.this.dEl.avE()).sr();
                            }
                            h.this.dEl.cQ(true);
                        }
                        TiebaStatic.eventStat(h.this.dSJ.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (avk.bar() != null && avk.gYa == 1) {
                            com.baidu.tieba.frs.e.b.a(avk, h.this.dEt.azw(), 1);
                        }
                        h.this.dSJ.refresh();
                    } else if (h.this.dEl.avE() instanceof com.baidu.tieba.frs.tab.a) {
                        ((com.baidu.tieba.frs.tab.a) h.this.dEl.avE()).azS();
                    }
                    TiebaStatic.log(new ak("c11749").ab(ImageViewerConfig.FORUM_ID, h.this.dSJ.getFid()).ab("obj_locate", "1"));
                }
            }
        };
        this.dEx = iVar.auM();
        iVar.registerListener(this.dVz);
    }

    public void c(com.baidu.tieba.frs.k kVar, boolean z) {
        if (kVar != null) {
            kVar.fU(z);
            kVar.a(this.bcF);
            kVar.a(this.bcH);
            kVar.a(this.bcG);
        }
    }
}
