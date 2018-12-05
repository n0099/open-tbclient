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
    private j.b aIE;
    private j.a aIF;
    private j.c aIG;
    private com.baidu.tieba.frs.smartsort.b dIr;
    private boolean edD;
    private final CustomMessageListener edE;
    private final BdExpandListView.a edF;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.edD = false;
        this.edE = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dId != null) {
                    h.this.dId.startPullRefresh();
                }
            }
        };
        this.aIE = new j.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (h.this.dZP != null && h.this.dZP.isAdded()) {
                    h.this.dId.di(true);
                    if (com.baidu.adp.lib.util.j.kV()) {
                        h.this.dZP.refresh();
                        if (h.this.dId != null) {
                            h.this.dZP.gs(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dZP.aAL();
                    }
                    TiebaStatic.log(new am("c11749").aA(ImageViewerConfig.FORUM_ID, h.this.dZP.getFid()).aA("obj_locate", "1"));
                }
            }
        };
        this.aIG = new j.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.j.c
            public void bI(boolean z) {
                h.this.edD = true;
                if (h.this.dId != null && h.this.eaN != null && h.this.dIo != null && h.this.dZP != null && h.this.dZP.isAdded()) {
                    if (h.this.dId != null && h.this.dId.aBx() != null) {
                        h.this.dId.aBx().aMx();
                    }
                    h.this.dZP.gs(false);
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dId.aBm() != null && h.this.eaN != null && h.this.dId.aBm().getVisibility() != 0) {
                                h.this.eaN.Qa();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.aIF = new j.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (h.this.dZP != null && h.this.dZP.isAdded()) {
                    if (h.this.edD && h.this.dZP.aAG() != null) {
                        h.this.dZP.aAG().aHx();
                        h.this.edD = false;
                    }
                    if (h.this.dIr != null && h.this.dZP.aAI() != null && h.this.dZP.aAI().aBz() != null && !h.this.dZP.aAI().aBz().aEc()) {
                        h.this.dIr.aGI();
                    }
                    if (h.this.dId != null && h.this.eaN != null && h.this.dIo != null && h.this.dIr != null) {
                        h.this.dId.aBx().b(0, 0, true, true);
                        h.this.dZP.aAP();
                        h.this.dZP.gs(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dZP.aAI() != null) {
                            h.this.dZP.aAI().di(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dZP.Fu().getVisibility() != 0 || v.I(h.this.dZP.aAZ().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.edF = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void N(float f) {
                if (h.this.dId != null && (h.this.dId.aBy() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dId.aBy()).M(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void oC() {
                if (h.this.dId != null && (h.this.dId.aBy() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dId.aBy()).aGO();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.dId != null && h.this.dId.aBx() != null) {
                    h.this.dId.aBx().aMx();
                }
                com.baidu.tieba.card.v.apD().ft(false);
                l aAZ = h.this.dZP.aAZ();
                if (h.this.dId != null && aAZ != null && h.this.dIn != null) {
                    if (com.baidu.adp.lib.util.j.kV()) {
                        if (h.this.dId.aBy() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!aAZ.bCB()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.dId.aBy()).oB();
                            }
                            h.this.dId.di(true);
                        }
                        TiebaStatic.eventStat(h.this.dZP.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (aAZ.bgi() != null && aAZ.hiz == 1) {
                            com.baidu.tieba.frs.e.b.a(aAZ, h.this.dIn.aGs(), 1);
                        }
                        h.this.dZP.refresh();
                    } else if (h.this.dId.aBy() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.dId.aBy()).aGO();
                    }
                    TiebaStatic.log(new am("c11749").aA(ImageViewerConfig.FORUM_ID, h.this.dZP.getFid()).aA("obj_locate", "1"));
                }
            }
        };
        this.dIr = frsFragment.aAC();
        frsFragment.registerListener(this.edE);
    }

    public void c(com.baidu.tieba.frs.k kVar, boolean z) {
        if (kVar != null) {
            kVar.gF(z);
            kVar.a(this.aIE);
            kVar.a(this.aIG);
            kVar.a(this.aIF);
        }
    }
}
