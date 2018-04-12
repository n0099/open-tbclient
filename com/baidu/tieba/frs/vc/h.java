package com.baidu.tieba.frs.vc;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private e.b anZ;
    private e.a aoa;
    private e.c aob;
    private com.baidu.tieba.frs.smartsort.b cXw;
    private boolean dqE;
    private final CustomMessageListener dqF;
    private final BdExpandListView.a dqG;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.dqE = false;
        this.dqF = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cXk != null) {
                    h.this.cXk.startPullRefresh();
                }
            }
        };
        this.anZ = new e.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (h.this.dmZ != null && h.this.dmZ.isAdded()) {
                    h.this.cXk.ch(true);
                    if (com.baidu.adp.lib.util.j.gP()) {
                        h.this.dmZ.refresh();
                        if (h.this.cXk != null) {
                            h.this.dmZ.fp(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dmZ.apq();
                    }
                    TiebaStatic.log(new al("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.dmZ.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.aob = new e.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.e.c
            public void aP(boolean z) {
                h.this.dqE = true;
                if (h.this.cXk != null && h.this.dnX != null && h.this.cXt != null && h.this.dmZ != null && h.this.dmZ.isAdded()) {
                    if (h.this.cXk != null && h.this.cXk.aqc() != null) {
                        h.this.cXk.aqc().aza();
                    }
                    h.this.dmZ.fp(false);
                    com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cXk.apP() != null && h.this.dnX != null && h.this.cXk.apP().getVisibility() != 0) {
                                h.this.dnX.HK();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.aoa = new e.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.e.a
            public void c(View view2, boolean z) {
                if (h.this.dmZ != null && h.this.dmZ.isAdded()) {
                    if (h.this.dqE && h.this.dmZ.apl() != null) {
                        h.this.dmZ.apl().avu();
                        h.this.dqE = false;
                    }
                    if (h.this.cXw != null && h.this.dmZ.apn() != null && h.this.dmZ.apn().aqe() != null && !h.this.dmZ.apn().aqe().asd()) {
                        h.this.cXw.auB();
                    }
                    if (h.this.cXk != null && h.this.dnX != null && h.this.cXt != null && h.this.cXw != null) {
                        h.this.dmZ.apu();
                        h.this.dmZ.fp(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dmZ.apn() != null) {
                            h.this.dmZ.apn().ch(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dmZ.xj().getVisibility() != 0 || v.w(h.this.dmZ.apE().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dqG = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void D(float f) {
                if (h.this.cXk != null && (h.this.cXk.aqd() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cXk.aqd()).C(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kz() {
                if (h.this.cXk != null && (h.this.cXk.aqd() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cXk.aqd()).auL();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.cXk != null && h.this.cXk.aqc() != null) {
                    h.this.cXk.aqc().aza();
                }
                com.baidu.tieba.card.v.afy().et(false);
                l apE = h.this.dmZ.apE();
                if (h.this.cXk != null && apE != null && h.this.cXs != null) {
                    if (com.baidu.adp.lib.util.j.gP()) {
                        if (h.this.cXk.aqd() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!apE.brj()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cXk.aqd()).ky();
                            }
                            h.this.cXk.ch(true);
                        }
                        TiebaStatic.eventStat(h.this.dmZ.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (apE.aVq() != null && apE.gtS == 1) {
                            com.baidu.tieba.frs.e.b.a(apE, h.this.cXs.aun(), 1);
                        }
                        h.this.dmZ.refresh();
                    } else if (h.this.cXk.aqd() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cXk.aqd()).auL();
                    }
                    TiebaStatic.log(new al("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.dmZ.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.cXw = frsFragment.apg();
        frsFragment.registerListener(this.dqF);
    }

    public void c(com.baidu.tieba.frs.i iVar, boolean z) {
        if (iVar != null) {
            iVar.fz(z);
            iVar.a(this.anZ);
            iVar.a(this.aob);
            iVar.a(this.aoa);
        }
    }
}
