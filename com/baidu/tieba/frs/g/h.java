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
import com.baidu.tieba.card.u;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private g.c amA;
    private g.b amy;
    private g.a amz;
    private final CustomMessageListener cRN;
    private final BdExpandListView.a cRO;
    private com.baidu.tieba.frs.smartsort.b cyh;

    public h(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cRN = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.g.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cxU != null) {
                    h.this.cxU.startPullRefresh();
                }
            }
        };
        this.amy = new g.b() { // from class: com.baidu.tieba.frs.g.h.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                if (h.this.cFg != null && h.this.cFg.isAdded()) {
                    h.this.cxU.cg(true);
                    if (j.hh()) {
                        h.this.cFg.refresh();
                        if (h.this.cxU != null) {
                            h.this.cFg.ez(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.cFg.ajn();
                    }
                    TiebaStatic.log(new ak("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.cFg.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.amA = new g.c() { // from class: com.baidu.tieba.frs.g.h.3
            @Override // com.baidu.tbadk.core.view.g.c
            public void aK(boolean z) {
                if (h.this.cxU != null && h.this.cOX != null && h.this.cye != null && h.this.cFg != null && h.this.cFg.isAdded()) {
                    if (h.this.cxU != null && h.this.cxU.ajJ() != null) {
                        h.this.cxU.ajJ().atL();
                    }
                    h.this.cFg.ez(false);
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cxU.ajG() != null && h.this.cOX != null && h.this.cxU.ajG().getVisibility() != 0) {
                                h.this.cOX.Hg();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.amz = new g.a() { // from class: com.baidu.tieba.frs.g.h.4
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (h.this.cFg != null && h.this.cFg.isAdded()) {
                    if (h.this.cyh != null && h.this.cFg.ajk() != null && h.this.cFg.ajk().ajL() != null && !h.this.cFg.ajk().ajL().alT()) {
                        h.this.cyh.aom();
                    }
                    if (h.this.cxU != null && h.this.cOX != null && h.this.cye != null && h.this.cyh != null) {
                        h.this.cFg.ajr();
                        h.this.cFg.ez(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.cFg.ajk() != null) {
                            h.this.cFg.ajk().cg(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.cFg.getListView().getVisibility() != 0 || v.v(h.this.cFg.ajB().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.cRO = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.g.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void v(float f) {
                if (h.this.cxU != null && (h.this.cxU.ajK() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cxU.ajK()).u(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kV() {
                if (h.this.cxU != null && (h.this.cxU.ajK() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cxU.ajK()).aox();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kW() {
                if (h.this.cxU != null && h.this.cxU.ajJ() != null) {
                    h.this.cxU.ajJ().atL();
                }
                u.aaj().dF(false);
                com.baidu.tieba.tbadkCore.j ajB = h.this.cFg.ajB();
                if (h.this.cxU != null && ajB != null && h.this.cyd != null) {
                    if (j.hh()) {
                        if (h.this.cxU.ajK() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!(h.this.cxU.getListView() instanceof BdExpandListView) || !((BdExpandListView) h.this.cxU.getListView()).btN()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cxU.ajK()).kU();
                            }
                            h.this.cxU.cg(true);
                        }
                        TiebaStatic.eventStat(h.this.cFg.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (ajB.aPU() != null && ajB.gnK == 1) {
                            com.baidu.tieba.frs.e.b.a(ajB, h.this.cyd.anY(), 1);
                        }
                        h.this.cFg.refresh();
                    } else if (h.this.cxU.ajK() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cxU.ajK()).aox();
                    }
                    TiebaStatic.log(new ak("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.cFg.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.cyh = fVar.aje();
        fVar.registerListener(this.cRN);
    }

    public void a(i iVar, boolean z) {
        if (iVar != null) {
            iVar.eI(z);
            iVar.a(this.amy);
            iVar.a(this.amA);
            iVar.a(this.amz);
        }
    }
}
