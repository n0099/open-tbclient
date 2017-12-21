package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.card.s;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private h.b amU;
    private h.a amV;
    private h.c amW;
    private com.baidu.tieba.frs.smartsort.b cHy;
    private final CustomMessageListener dbj;
    private final BdExpandListView.a dbk;

    public h(com.baidu.tieba.frs.g gVar) {
        super(gVar);
        this.dbj = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.g.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cHm != null) {
                    h.this.cHm.startPullRefresh();
                }
            }
        };
        this.amU = new h.b() { // from class: com.baidu.tieba.frs.g.h.2
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefresh(boolean z) {
                if (h.this.cOB != null && h.this.cOB.isAdded()) {
                    h.this.cHm.ck(true);
                    if (j.hh()) {
                        h.this.cOB.refresh();
                        if (h.this.cHm != null) {
                            h.this.cOB.eR(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.cOB.alq();
                    }
                    TiebaStatic.log(new ak("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.cOB.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.amW = new h.c() { // from class: com.baidu.tieba.frs.g.h.3
            @Override // com.baidu.tbadk.core.view.h.c
            public void aL(boolean z) {
                if (h.this.cHm != null && h.this.cYC != null && h.this.cHv != null && h.this.cOB != null && h.this.cOB.isAdded()) {
                    if (h.this.cHm != null && h.this.cHm.alM() != null) {
                        h.this.cHm.alM().avu();
                    }
                    h.this.cOB.eR(false);
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cHm.alJ() != null && h.this.cYC != null && h.this.cHm.alJ().getVisibility() != 0) {
                                h.this.cYC.Ho();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.amV = new h.a() { // from class: com.baidu.tieba.frs.g.h.4
            @Override // com.baidu.tbadk.core.view.h.a
            public void b(View view, boolean z) {
                if (h.this.cOB != null && h.this.cOB.isAdded()) {
                    if (h.this.cHy != null && h.this.cOB.aln() != null && h.this.cOB.aln().alO() != null && !h.this.cOB.aln().alO().anX()) {
                        h.this.cHy.aqp();
                    }
                    if (h.this.cHm != null && h.this.cYC != null && h.this.cHv != null && h.this.cHy != null) {
                        h.this.cOB.alu();
                        h.this.cOB.eR(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.cOB.aln() != null) {
                            h.this.cOB.aln().ck(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.cOB.getListView().getVisibility() != 0 || v.w(h.this.cOB.alE().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dbk = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.g.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void v(float f) {
                if (h.this.cHm != null && (h.this.cHm.alN() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cHm.alN()).u(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kV() {
                if (h.this.cHm != null && (h.this.cHm.alN() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cHm.alN()).aqA();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kW() {
                if (h.this.cHm != null && h.this.cHm.alM() != null) {
                    h.this.cHm.alM().avu();
                }
                s.abW().dU(false);
                k alE = h.this.cOB.alE();
                if (h.this.cHm != null && alE != null && h.this.cHu != null) {
                    if (j.hh()) {
                        if (h.this.cHm.alN() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!(h.this.cHm.getListView() instanceof BdExpandListView) || !((BdExpandListView) h.this.cHm.getListView()).bwc()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cHm.alN()).kU();
                            }
                            h.this.cHm.ck(true);
                        }
                        TiebaStatic.eventStat(h.this.cOB.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (alE.aRo() != null && alE.gzq == 1) {
                            com.baidu.tieba.frs.e.b.a(alE, h.this.cHu.aqb(), 1);
                        }
                        h.this.cOB.refresh();
                    } else if (h.this.cHm.alN() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cHm.alN()).aqA();
                    }
                    TiebaStatic.log(new ak("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.cOB.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.cHy = gVar.alh();
        gVar.registerListener(this.dbj);
    }

    public void a(com.baidu.tieba.frs.j jVar, boolean z) {
        if (jVar != null) {
            jVar.fa(z);
            jVar.a(this.amU);
            jVar.a(this.amW);
            jVar.a(this.amV);
        }
    }
}
