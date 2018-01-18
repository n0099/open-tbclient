package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.card.s;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.view.a;
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private j.b baR;
    private j.a baS;
    private j.c baT;
    private com.baidu.tieba.frs.smartsort.b dBu;
    private final CustomMessageListener dRZ;
    private final a.InterfaceC0166a dSa;

    public h(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dRZ = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.f.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dBi != null) {
                    h.this.dBi.startPullRefresh();
                }
            }
        };
        this.baR = new j.b() { // from class: com.baidu.tieba.frs.f.h.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void onListPullRefresh(boolean z) {
                if (h.this.dPp != null && h.this.dPp.isAdded()) {
                    h.this.dBi.cL(true);
                    if (com.baidu.adp.lib.util.j.oI()) {
                        h.this.dPp.refresh();
                        if (h.this.dBi != null) {
                            h.this.dPp.fB(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dPp.aub();
                    }
                    TiebaStatic.log(new ak("c11749").ab(ImageViewerConfig.FORUM_ID, h.this.dPp.getFid()).ab("obj_locate", "1"));
                }
            }
        };
        this.baT = new j.c() { // from class: com.baidu.tieba.frs.f.h.3
            @Override // com.baidu.tbadk.core.view.j.c
            public void br(boolean z) {
                if (h.this.dBi != null && h.this.dQk != null && h.this.dBr != null && h.this.dPp != null && h.this.dPp.isAdded()) {
                    if (h.this.dBi != null && h.this.dBi.auz() != null) {
                        h.this.dBi.auz().aCB();
                    }
                    h.this.dPp.fB(false);
                    com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.f.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dBi.auw() != null && h.this.dQk != null && h.this.dBi.auw().getVisibility() != 0) {
                                h.this.dQk.OB();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.baS = new j.a() { // from class: com.baidu.tieba.frs.f.h.4
            @Override // com.baidu.tbadk.core.view.j.a
            public void i(View view, boolean z) {
                if (h.this.dPp != null && h.this.dPp.isAdded()) {
                    if (h.this.dBu != null && h.this.dPp.atY() != null && h.this.dPp.atY().auB() != null && !h.this.dPp.atY().auB().awA()) {
                        h.this.dBu.ayE();
                    }
                    if (h.this.dBi != null && h.this.dQk != null && h.this.dBr != null && h.this.dBu != null) {
                        h.this.dPp.auf();
                        h.this.dPp.fB(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.dPp.atY() != null) {
                            h.this.dPp.atY().cL(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dPp.Ec().getVisibility() != 0 || v.E(h.this.dPp.auq().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dSa = new a.InterfaceC0166a() { // from class: com.baidu.tieba.frs.f.h.5
            @Override // com.baidu.tieba.view.a.InterfaceC0166a
            public void L(float f) {
                if (h.this.dBi != null && (h.this.dBi.auA() instanceof com.baidu.tieba.frs.tab.a)) {
                    ((com.baidu.tieba.frs.tab.a) h.this.dBi.auA()).K(f);
                }
            }

            @Override // com.baidu.tieba.view.a.InterfaceC0166a
            public void st() {
                if (h.this.dBi != null && (h.this.dBi.auA() instanceof com.baidu.tieba.frs.tab.a)) {
                    ((com.baidu.tieba.frs.tab.a) h.this.dBi.auA()).ayM();
                }
            }

            @Override // com.baidu.tieba.view.a.InterfaceC0166a
            public void onRefresh() {
                if (h.this.dBi != null && h.this.dBi.auz() != null) {
                    h.this.dBi.auz().aCB();
                }
                s.akF().eF(false);
                l auq = h.this.dPp.auq();
                if (h.this.dBi != null && auq != null && h.this.dBq != null) {
                    if (com.baidu.adp.lib.util.j.oI()) {
                        if (h.this.dBi.auA() instanceof com.baidu.tieba.frs.tab.a) {
                            if (!auq.buN()) {
                                ((com.baidu.tieba.frs.tab.a) h.this.dBi.auA()).ss();
                            }
                            h.this.dBi.cL(true);
                        }
                        TiebaStatic.eventStat(h.this.dPp.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (auq.aYE() != null && auq.gVC == 1) {
                            com.baidu.tieba.frs.d.b.a(auq, h.this.dBq.ayq(), 1);
                        }
                        h.this.dPp.refresh();
                    } else if (h.this.dBi.auA() instanceof com.baidu.tieba.frs.tab.a) {
                        ((com.baidu.tieba.frs.tab.a) h.this.dBi.auA()).ayM();
                    }
                    TiebaStatic.log(new ak("c11749").ab(ImageViewerConfig.FORUM_ID, h.this.dPp.getFid()).ab("obj_locate", "1"));
                }
            }
        };
        this.dBu = iVar.atS();
        iVar.registerListener(this.dRZ);
    }

    public void a(com.baidu.tieba.frs.k kVar, boolean z) {
        if (kVar != null) {
            kVar.fK(z);
            kVar.a(this.baR);
            kVar.a(this.baT);
            kVar.a(this.baS);
        }
    }
}
