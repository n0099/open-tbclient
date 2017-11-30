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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private g.b amU;
    private g.a amV;
    private g.c amW;
    private com.baidu.tieba.frs.smartsort.b cHm;
    private final CustomMessageListener daR;
    private final BdExpandListView.a daS;

    public h(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.daR = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.g.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cHa != null) {
                    h.this.cHa.startPullRefresh();
                }
            }
        };
        this.amU = new g.b() { // from class: com.baidu.tieba.frs.g.h.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                if (h.this.cOm != null && h.this.cOm.isAdded()) {
                    h.this.cHa.cj(true);
                    if (j.hh()) {
                        h.this.cOm.refresh();
                        if (h.this.cHa != null) {
                            h.this.cOm.eQ(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.cOm.alh();
                    }
                    TiebaStatic.log(new ak("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.cOm.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.amW = new g.c() { // from class: com.baidu.tieba.frs.g.h.3
            @Override // com.baidu.tbadk.core.view.g.c
            public void aK(boolean z) {
                if (h.this.cHa != null && h.this.cYm != null && h.this.cHj != null && h.this.cOm != null && h.this.cOm.isAdded()) {
                    if (h.this.cHa != null && h.this.cHa.alD() != null) {
                        h.this.cHa.alD().avl();
                    }
                    h.this.cOm.eQ(false);
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cHa.alA() != null && h.this.cYm != null && h.this.cHa.alA().getVisibility() != 0) {
                                h.this.cYm.Hn();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.amV = new g.a() { // from class: com.baidu.tieba.frs.g.h.4
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (h.this.cOm != null && h.this.cOm.isAdded()) {
                    if (h.this.cHm != null && h.this.cOm.ale() != null && h.this.cOm.ale().alF() != null && !h.this.cOm.ale().alF().anO()) {
                        h.this.cHm.aqg();
                    }
                    if (h.this.cHa != null && h.this.cYm != null && h.this.cHj != null && h.this.cHm != null) {
                        h.this.cOm.all();
                        h.this.cOm.eQ(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.cOm.ale() != null) {
                            h.this.cOm.ale().cj(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.cOm.getListView().getVisibility() != 0 || v.w(h.this.cOm.alv().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.daS = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.g.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void v(float f) {
                if (h.this.cHa != null && (h.this.cHa.alE() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cHa.alE()).u(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kV() {
                if (h.this.cHa != null && (h.this.cHa.alE() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cHa.alE()).aqr();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kW() {
                if (h.this.cHa != null && h.this.cHa.alD() != null) {
                    h.this.cHa.alD().avl();
                }
                s.abU().dT(false);
                k alv = h.this.cOm.alv();
                if (h.this.cHa != null && alv != null && h.this.cHi != null) {
                    if (j.hh()) {
                        if (h.this.cHa.alE() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!(h.this.cHa.getListView() instanceof BdExpandListView) || !((BdExpandListView) h.this.cHa.getListView()).bvv()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cHa.alE()).kU();
                            }
                            h.this.cHa.cj(true);
                        }
                        TiebaStatic.eventStat(h.this.cOm.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (alv.aRf() != null && alv.gwD == 1) {
                            com.baidu.tieba.frs.e.b.a(alv, h.this.cHi.apS(), 1);
                        }
                        h.this.cOm.refresh();
                    } else if (h.this.cHa.alE() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cHa.alE()).aqr();
                    }
                    TiebaStatic.log(new ak("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.cOm.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.cHm = fVar.akY();
        fVar.registerListener(this.daR);
    }

    public void a(i iVar, boolean z) {
        if (iVar != null) {
            iVar.eZ(z);
            iVar.a(this.amU);
            iVar.a(this.amW);
            iVar.a(this.amV);
        }
    }
}
