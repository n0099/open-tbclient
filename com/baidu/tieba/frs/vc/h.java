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
    private j.b aIF;
    private j.a aIG;
    private j.c aIH;
    private com.baidu.tieba.frs.smartsort.b dLf;
    private boolean egu;
    private final CustomMessageListener egv;
    private final BdExpandListView.a egw;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.egu = false;
        this.egv = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dKR != null) {
                    h.this.dKR.startPullRefresh();
                }
            }
        };
        this.aIF = new j.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (h.this.ecG != null && h.this.ecG.isAdded()) {
                    h.this.dKR.di(true);
                    if (com.baidu.adp.lib.util.j.kV()) {
                        h.this.ecG.refresh();
                        if (h.this.dKR != null) {
                            h.this.ecG.gv(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.ecG.aBA();
                    }
                    TiebaStatic.log(new am("c11749").aA(ImageViewerConfig.FORUM_ID, h.this.ecG.getFid()).aA("obj_locate", "1"));
                }
            }
        };
        this.aIH = new j.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.j.c
            public void bI(boolean z) {
                h.this.egu = true;
                if (h.this.dKR != null && h.this.edE != null && h.this.dLc != null && h.this.ecG != null && h.this.ecG.isAdded()) {
                    if (h.this.dKR != null && h.this.dKR.aCm() != null) {
                        h.this.dKR.aCm().aNk();
                    }
                    h.this.ecG.gv(false);
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dKR.aCb() != null && h.this.edE != null && h.this.dKR.aCb().getVisibility() != 0) {
                                h.this.edE.Qc();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.aIG = new j.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (h.this.ecG != null && h.this.ecG.isAdded()) {
                    if (h.this.egu && h.this.ecG.aBv() != null) {
                        h.this.ecG.aBv().aIm();
                        h.this.egu = false;
                    }
                    if (h.this.dLf != null && h.this.ecG.aBx() != null && h.this.ecG.aBx().aCo() != null && !h.this.ecG.aBx().aCo().aER()) {
                        h.this.dLf.aHx();
                    }
                    if (h.this.dKR != null && h.this.edE != null && h.this.dLc != null && h.this.dLf != null) {
                        h.this.dKR.aCm().b(0, 0, true, true);
                        h.this.ecG.aBE();
                        h.this.ecG.gv(true);
                        h.this.ecG.gs(false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.ecG.aBx() != null) {
                            h.this.ecG.aBx().di(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.ecG.Fv().getVisibility() != 0 || v.I(h.this.ecG.aBO().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.egw = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void N(float f) {
                if (h.this.dKR != null && (h.this.dKR.aCn() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dKR.aCn()).M(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void oC() {
                if (h.this.dKR != null && (h.this.dKR.aCn() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dKR.aCn()).aHD();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.dKR != null && h.this.dKR.aCm() != null) {
                    h.this.dKR.aCm().aNk();
                }
                com.baidu.tieba.card.v.aqs().fv(false);
                l aBO = h.this.ecG.aBO();
                if (h.this.dKR != null && aBO != null && h.this.dLb != null) {
                    if (com.baidu.adp.lib.util.j.kV()) {
                        if (h.this.dKR.aCn() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!aBO.bDs()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.dKR.aCn()).oB();
                            }
                            h.this.dKR.di(true);
                        }
                        TiebaStatic.eventStat(h.this.ecG.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (aBO.bgT() != null && aBO.hlK == 1) {
                            com.baidu.tieba.frs.e.c.a(aBO, h.this.dLb.aHh(), 1);
                        }
                        h.this.ecG.refresh();
                    } else if (h.this.dKR.aCn() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.dKR.aCn()).aHD();
                    }
                    TiebaStatic.log(new am("c11749").aA(ImageViewerConfig.FORUM_ID, h.this.ecG.getFid()).aA("obj_locate", "1"));
                }
            }
        };
        this.dLf = frsFragment.aBr();
        frsFragment.registerListener(this.egv);
    }

    public void c(com.baidu.tieba.frs.k kVar, boolean z) {
        if (kVar != null) {
            kVar.gI(z);
            kVar.a(this.aIF);
            kVar.a(this.aIH);
            kVar.a(this.aIG);
        }
    }
}
