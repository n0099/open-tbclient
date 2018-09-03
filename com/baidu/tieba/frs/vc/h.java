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
    private g.b awt;
    private g.a awu;
    private g.c awv;
    private boolean dGQ;
    private final CustomMessageListener dGR;
    private final BdExpandListView.a dGS;
    private com.baidu.tieba.frs.smartsort.b dmD;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.dGQ = false;
        this.dGR = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dmo != null) {
                    h.this.dmo.startPullRefresh();
                }
            }
        };
        this.awt = new g.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                if (h.this.dDt != null && h.this.dDt.isAdded()) {
                    h.this.dmo.cq(true);
                    if (com.baidu.adp.lib.util.j.jE()) {
                        h.this.dDt.refresh();
                        if (h.this.dmo != null) {
                            h.this.dDt.fy(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dDt.auo();
                    }
                    TiebaStatic.log(new an("c11749").ae(ImageViewerConfig.FORUM_ID, h.this.dDt.getFid()).ae("obj_locate", "1"));
                }
            }
        };
        this.awv = new g.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.g.c
            public void aU(boolean z) {
                h.this.dGQ = true;
                if (h.this.dmo != null && h.this.dEr != null && h.this.dmA != null && h.this.dDt != null && h.this.dDt.isAdded()) {
                    if (h.this.dmo != null && h.this.dmo.avb() != null) {
                        h.this.dmo.avb().aFA();
                    }
                    h.this.dDt.fy(false);
                    com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dmo.auO() != null && h.this.dEr != null && h.this.dmo.auO().getVisibility() != 0) {
                                h.this.dEr.Lv();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.awu = new g.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (h.this.dDt != null && h.this.dDt.isAdded()) {
                    if (h.this.dGQ && h.this.dDt.auj() != null) {
                        h.this.dDt.auj().aAN();
                        h.this.dGQ = false;
                    }
                    if (h.this.dmD != null && h.this.dDt.aul() != null && h.this.dDt.aul().avd() != null && !h.this.dDt.aul().avd().axp()) {
                        h.this.dmD.azY();
                    }
                    if (h.this.dmo != null && h.this.dEr != null && h.this.dmA != null && h.this.dmD != null) {
                        h.this.dmo.avb().b(0, 0, true, true);
                        h.this.dDt.aus();
                        h.this.dDt.fy(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dDt.aul() != null) {
                            h.this.dDt.aul().cq(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dDt.AP().getVisibility() != 0 || w.z(h.this.dDt.auC().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dGS = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void N(float f) {
                if (h.this.dmo != null && (h.this.dmo.avc() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dmo.avc()).M(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void no() {
                if (h.this.dmo != null && (h.this.dmo.avc() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dmo.avc()).aAe();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.dmo != null && h.this.dmo.avb() != null) {
                    h.this.dmo.avb().aFA();
                }
                v.ajb().ey(false);
                l auC = h.this.dDt.auC();
                if (h.this.dmo != null && auC != null && h.this.dmz != null) {
                    if (com.baidu.adp.lib.util.j.jE()) {
                        if (h.this.dmo.avc() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!auC.bvp()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.dmo.avc()).nn();
                            }
                            h.this.dmo.cq(true);
                        }
                        TiebaStatic.eventStat(h.this.dDt.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (auC.aZg() != null && auC.gLl == 1) {
                            com.baidu.tieba.frs.e.b.a(auC, h.this.dmz.azI(), 1);
                        }
                        h.this.dDt.refresh();
                    } else if (h.this.dmo.avc() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.dmo.avc()).aAe();
                    }
                    TiebaStatic.log(new an("c11749").ae(ImageViewerConfig.FORUM_ID, h.this.dDt.getFid()).ae("obj_locate", "1"));
                }
            }
        };
        this.dmD = frsFragment.auf();
        frsFragment.registerListener(this.dGR);
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            kVar.fL(z);
            kVar.a(this.awt);
            kVar.a(this.awv);
            kVar.a(this.awu);
        }
    }
}
