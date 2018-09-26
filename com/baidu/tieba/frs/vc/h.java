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
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private j.b azG;
    private j.a azH;
    private j.c azI;
    private boolean dNX;
    private final CustomMessageListener dNY;
    private final BdExpandListView.a dNZ;
    private com.baidu.tieba.frs.smartsort.b dsA;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.dNX = false;
        this.dNY = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dsl != null) {
                    h.this.dsl.startPullRefresh();
                }
            }
        };
        this.azG = new j.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                if (h.this.dKj != null && h.this.dKj.isAdded()) {
                    h.this.dsl.cH(true);
                    if (com.baidu.adp.lib.util.j.kK()) {
                        h.this.dKj.refresh();
                        if (h.this.dsl != null) {
                            h.this.dKj.fP(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dKj.awh();
                    }
                    TiebaStatic.log(new am("c11749").al(ImageViewerConfig.FORUM_ID, h.this.dKj.getFid()).al("obj_locate", "1"));
                }
            }
        };
        this.azI = new j.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.j.c
            public void bg(boolean z) {
                h.this.dNX = true;
                if (h.this.dsl != null && h.this.dLh != null && h.this.dsx != null && h.this.dKj != null && h.this.dKj.isAdded()) {
                    if (h.this.dsl != null && h.this.dsl.awU() != null) {
                        h.this.dsl.awU().aHP();
                    }
                    h.this.dKj.fP(false);
                    com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dsl.awH() != null && h.this.dLh != null && h.this.dsl.awH().getVisibility() != 0) {
                                h.this.dLh.MN();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.azH = new j.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.j.a
            public void b(View view, boolean z) {
                if (h.this.dKj != null && h.this.dKj.isAdded()) {
                    if (h.this.dNX && h.this.dKj.awc() != null) {
                        h.this.dKj.awc().aCX();
                        h.this.dNX = false;
                    }
                    if (h.this.dsA != null && h.this.dKj.awe() != null && h.this.dKj.awe().awW() != null && !h.this.dKj.awe().awW().azC()) {
                        h.this.dsA.aCh();
                    }
                    if (h.this.dsl != null && h.this.dLh != null && h.this.dsx != null && h.this.dsA != null) {
                        h.this.dsl.awU().b(0, 0, true, true);
                        h.this.dKj.awl();
                        h.this.dKj.fP(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dKj.awe() != null) {
                            h.this.dKj.awe().cH(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dKj.Cb().getVisibility() != 0 || v.z(h.this.dKj.awv().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dNZ = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void N(float f) {
                if (h.this.dsl != null && (h.this.dsl.awV() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dsl.awV()).M(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void ou() {
                if (h.this.dsl != null && (h.this.dsl.awV() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dsl.awV()).aCn();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.dsl != null && h.this.dsl.awU() != null) {
                    h.this.dsl.awU().aHP();
                }
                com.baidu.tieba.card.v.akM().eP(false);
                l awv = h.this.dKj.awv();
                if (h.this.dsl != null && awv != null && h.this.dsw != null) {
                    if (com.baidu.adp.lib.util.j.kK()) {
                        if (h.this.dsl.awV() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!awv.bxV()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.dsl.awV()).ot();
                            }
                            h.this.dsl.cH(true);
                        }
                        TiebaStatic.eventStat(h.this.dKj.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (awv.bbH() != null && awv.gSN == 1) {
                            com.baidu.tieba.frs.e.b.a(awv, h.this.dsw.aBR(), 1);
                        }
                        h.this.dKj.refresh();
                    } else if (h.this.dsl.awV() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.dsl.awV()).aCn();
                    }
                    TiebaStatic.log(new am("c11749").al(ImageViewerConfig.FORUM_ID, h.this.dKj.getFid()).al("obj_locate", "1"));
                }
            }
        };
        this.dsA = frsFragment.avY();
        frsFragment.registerListener(this.dNY);
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            kVar.gc(z);
            kVar.a(this.azG);
            kVar.a(this.azI);
            kVar.a(this.azH);
        }
    }
}
