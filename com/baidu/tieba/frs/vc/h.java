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
    private j.b aFe;
    private j.a aFf;
    private j.c aFg;
    private com.baidu.tieba.frs.smartsort.b dBS;
    private boolean dWZ;
    private final CustomMessageListener dXa;
    private final BdExpandListView.a dXb;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.dWZ = false;
        this.dXa = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dBE != null) {
                    h.this.dBE.startPullRefresh();
                }
            }
        };
        this.aFe = new j.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                if (h.this.dTm != null && h.this.dTm.isAdded()) {
                    h.this.dBE.dh(true);
                    if (com.baidu.adp.lib.util.j.kV()) {
                        h.this.dTm.refresh();
                        if (h.this.dBE != null) {
                            h.this.dTm.gr(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dTm.azb();
                    }
                    TiebaStatic.log(new am("c11749").ax(ImageViewerConfig.FORUM_ID, h.this.dTm.getFid()).ax("obj_locate", "1"));
                }
            }
        };
        this.aFg = new j.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.j.c
            public void bH(boolean z) {
                h.this.dWZ = true;
                if (h.this.dBE != null && h.this.dUk != null && h.this.dBP != null && h.this.dTm != null && h.this.dTm.isAdded()) {
                    if (h.this.dBE != null && h.this.dBE.azN() != null) {
                        h.this.dBE.azN().aKF();
                    }
                    h.this.dTm.gr(false);
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dBE.azB() != null && h.this.dUk != null && h.this.dBE.azB().getVisibility() != 0) {
                                h.this.dUk.OU();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.aFf = new j.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (h.this.dTm != null && h.this.dTm.isAdded()) {
                    if (h.this.dWZ && h.this.dTm.ayW() != null) {
                        h.this.dTm.ayW().aFL();
                        h.this.dWZ = false;
                    }
                    if (h.this.dBS != null && h.this.dTm.ayY() != null && h.this.dTm.ayY().azP() != null && !h.this.dTm.ayY().azP().aCq()) {
                        h.this.dBS.aEW();
                    }
                    if (h.this.dBE != null && h.this.dUk != null && h.this.dBP != null && h.this.dBS != null) {
                        h.this.dBE.azN().b(0, 0, true, true);
                        h.this.dTm.azf();
                        h.this.dTm.gr(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dTm.ayY() != null) {
                            h.this.dTm.ayY().dh(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dTm.Eq().getVisibility() != 0 || v.I(h.this.dTm.azp().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dXb = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void N(float f) {
                if (h.this.dBE != null && (h.this.dBE.azO() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dBE.azO()).M(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void oD() {
                if (h.this.dBE != null && (h.this.dBE.azO() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dBE.azO()).aFc();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.dBE != null && h.this.dBE.azN() != null) {
                    h.this.dBE.azN().aKF();
                }
                com.baidu.tieba.card.v.anQ().fs(false);
                l azp = h.this.dTm.azp();
                if (h.this.dBE != null && azp != null && h.this.dBO != null) {
                    if (com.baidu.adp.lib.util.j.kV()) {
                        if (h.this.dBE.azO() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!azp.bAG()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.dBE.azO()).oC();
                            }
                            h.this.dBE.dh(true);
                        }
                        TiebaStatic.eventStat(h.this.dTm.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (azp.ber() != null && azp.hbG == 1) {
                            com.baidu.tieba.frs.e.b.a(azp, h.this.dBO.aEG(), 1);
                        }
                        h.this.dTm.refresh();
                    } else if (h.this.dBE.azO() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.dBE.azO()).aFc();
                    }
                    TiebaStatic.log(new am("c11749").ax(ImageViewerConfig.FORUM_ID, h.this.dTm.getFid()).ax("obj_locate", "1"));
                }
            }
        };
        this.dBS = frsFragment.ayS();
        frsFragment.registerListener(this.dXa);
    }

    public void c(com.baidu.tieba.frs.k kVar, boolean z) {
        if (kVar != null) {
            kVar.gE(z);
            kVar.a(this.aFe);
            kVar.a(this.aFg);
            kVar.a(this.aFf);
        }
    }
}
