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
    private com.baidu.tieba.frs.smartsort.b cXt;
    private boolean dqB;
    private final CustomMessageListener dqC;
    private final BdExpandListView.a dqD;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.dqB = false;
        this.dqC = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cXh != null) {
                    h.this.cXh.startPullRefresh();
                }
            }
        };
        this.anZ = new e.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (h.this.dmW != null && h.this.dmW.isAdded()) {
                    h.this.cXh.ch(true);
                    if (com.baidu.adp.lib.util.j.gP()) {
                        h.this.dmW.refresh();
                        if (h.this.cXh != null) {
                            h.this.dmW.fp(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dmW.apq();
                    }
                    TiebaStatic.log(new al("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.dmW.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.aob = new e.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.e.c
            public void aP(boolean z) {
                h.this.dqB = true;
                if (h.this.cXh != null && h.this.dnU != null && h.this.cXq != null && h.this.dmW != null && h.this.dmW.isAdded()) {
                    if (h.this.cXh != null && h.this.cXh.aqc() != null) {
                        h.this.cXh.aqc().aza();
                    }
                    h.this.dmW.fp(false);
                    com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cXh.apP() != null && h.this.dnU != null && h.this.cXh.apP().getVisibility() != 0) {
                                h.this.dnU.HK();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.aoa = new e.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.e.a
            public void c(View view2, boolean z) {
                if (h.this.dmW != null && h.this.dmW.isAdded()) {
                    if (h.this.dqB && h.this.dmW.apl() != null) {
                        h.this.dmW.apl().avu();
                        h.this.dqB = false;
                    }
                    if (h.this.cXt != null && h.this.dmW.apn() != null && h.this.dmW.apn().aqe() != null && !h.this.dmW.apn().aqe().asd()) {
                        h.this.cXt.auB();
                    }
                    if (h.this.cXh != null && h.this.dnU != null && h.this.cXq != null && h.this.cXt != null) {
                        h.this.dmW.apu();
                        h.this.dmW.fp(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dmW.apn() != null) {
                            h.this.dmW.apn().ch(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dmW.xj().getVisibility() != 0 || v.w(h.this.dmW.apE().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dqD = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void D(float f) {
                if (h.this.cXh != null && (h.this.cXh.aqd() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cXh.aqd()).C(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kz() {
                if (h.this.cXh != null && (h.this.cXh.aqd() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cXh.aqd()).auL();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.cXh != null && h.this.cXh.aqc() != null) {
                    h.this.cXh.aqc().aza();
                }
                com.baidu.tieba.card.v.afy().et(false);
                l apE = h.this.dmW.apE();
                if (h.this.cXh != null && apE != null && h.this.cXp != null) {
                    if (com.baidu.adp.lib.util.j.gP()) {
                        if (h.this.cXh.aqd() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!apE.brj()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cXh.aqd()).ky();
                            }
                            h.this.cXh.ch(true);
                        }
                        TiebaStatic.eventStat(h.this.dmW.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (apE.aVq() != null && apE.gtP == 1) {
                            com.baidu.tieba.frs.e.b.a(apE, h.this.cXp.aun(), 1);
                        }
                        h.this.dmW.refresh();
                    } else if (h.this.cXh.aqd() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cXh.aqd()).auL();
                    }
                    TiebaStatic.log(new al("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.dmW.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.cXt = frsFragment.apg();
        frsFragment.registerListener(this.dqC);
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
