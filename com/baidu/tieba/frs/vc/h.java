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
    private g.b awQ;
    private g.a awR;
    private g.c awS;
    private boolean dEi;
    private final CustomMessageListener dEj;
    private final BdExpandListView.a dEk;
    private com.baidu.tieba.frs.smartsort.b djP;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.dEi = false;
        this.dEj = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.djA != null) {
                    h.this.djA.startPullRefresh();
                }
            }
        };
        this.awQ = new g.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                if (h.this.dAK != null && h.this.dAK.isAdded()) {
                    h.this.djA.cp(true);
                    if (com.baidu.adp.lib.util.j.jD()) {
                        h.this.dAK.refresh();
                        if (h.this.djA != null) {
                            h.this.dAK.fw(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dAK.atL();
                    }
                    TiebaStatic.log(new an("c11749").ah(ImageViewerConfig.FORUM_ID, h.this.dAK.getFid()).ah("obj_locate", "1"));
                }
            }
        };
        this.awS = new g.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.g.c
            public void aV(boolean z) {
                h.this.dEi = true;
                if (h.this.djA != null && h.this.dBI != null && h.this.djM != null && h.this.dAK != null && h.this.dAK.isAdded()) {
                    if (h.this.djA != null && h.this.djA.auy() != null) {
                        h.this.djA.auy().aED();
                    }
                    h.this.dAK.fw(false);
                    com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.djA.aul() != null && h.this.dBI != null && h.this.djA.aul().getVisibility() != 0) {
                                h.this.dBI.Lw();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.awR = new g.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.g.a
            public void c(View view, boolean z) {
                if (h.this.dAK != null && h.this.dAK.isAdded()) {
                    if (h.this.dEi && h.this.dAK.atG() != null) {
                        h.this.dAK.atG().aAj();
                        h.this.dEi = false;
                    }
                    if (h.this.djP != null && h.this.dAK.atI() != null && h.this.dAK.atI().auA() != null && !h.this.dAK.atI().auA().awL()) {
                        h.this.djP.azu();
                    }
                    if (h.this.djA != null && h.this.dBI != null && h.this.djM != null && h.this.djP != null) {
                        h.this.dAK.atP();
                        h.this.dAK.fw(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dAK.atI() != null) {
                            h.this.dAK.atI().cp(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dAK.Bb().getVisibility() != 0 || w.A(h.this.dAK.atZ().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dEk = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void N(float f) {
                if (h.this.djA != null && (h.this.djA.auz() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.djA.auz()).M(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void nm() {
                if (h.this.djA != null && (h.this.djA.auz() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.djA.auz()).azA();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.djA != null && h.this.djA.auy() != null) {
                    h.this.djA.auy().aED();
                }
                v.aiz().ex(false);
                l atZ = h.this.dAK.atZ();
                if (h.this.djA != null && atZ != null && h.this.djL != null) {
                    if (com.baidu.adp.lib.util.j.jD()) {
                        if (h.this.djA.auz() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!atZ.bwK()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.djA.auz()).nl();
                            }
                            h.this.djA.cp(true);
                        }
                        TiebaStatic.eventStat(h.this.dAK.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (atZ.baT() != null && atZ.gKm == 1) {
                            com.baidu.tieba.frs.e.b.a(atZ, h.this.djL.azf(), 1);
                        }
                        h.this.dAK.refresh();
                    } else if (h.this.djA.auz() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.djA.auz()).azA();
                    }
                    TiebaStatic.log(new an("c11749").ah(ImageViewerConfig.FORUM_ID, h.this.dAK.getFid()).ah("obj_locate", "1"));
                }
            }
        };
        this.djP = frsFragment.atC();
        frsFragment.registerListener(this.dEj);
    }

    public void c(k kVar, boolean z) {
        if (kVar != null) {
            kVar.fJ(z);
            kVar.a(this.awQ);
            kVar.a(this.awS);
            kVar.a(this.awR);
        }
    }
}
