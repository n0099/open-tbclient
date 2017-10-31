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
    private g.a amA;
    private g.c amB;
    private g.b amz;
    private final CustomMessageListener cRt;
    private final BdExpandListView.a cRu;
    private com.baidu.tieba.frs.smartsort.b cxO;

    public h(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cRt = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.g.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cxB != null) {
                    h.this.cxB.startPullRefresh();
                }
            }
        };
        this.amz = new g.b() { // from class: com.baidu.tieba.frs.g.h.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                if (h.this.cEN != null && h.this.cEN.isAdded()) {
                    h.this.cxB.cf(true);
                    if (j.hh()) {
                        h.this.cEN.refresh();
                        if (h.this.cxB != null) {
                            h.this.cEN.eu(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.cEN.aiZ();
                    }
                    TiebaStatic.log(new ak("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.cEN.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.amB = new g.c() { // from class: com.baidu.tieba.frs.g.h.3
            @Override // com.baidu.tbadk.core.view.g.c
            public void aK(boolean z) {
                if (h.this.cxB != null && h.this.cOD != null && h.this.cxL != null && h.this.cEN != null && h.this.cEN.isAdded()) {
                    if (h.this.cxB != null && h.this.cxB.ajv() != null) {
                        h.this.cxB.ajv().atu();
                    }
                    h.this.cEN.eu(false);
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cxB.ajs() != null && h.this.cOD != null && h.this.cxB.ajs().getVisibility() != 0) {
                                h.this.cOD.GV();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.amA = new g.a() { // from class: com.baidu.tieba.frs.g.h.4
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (h.this.cEN != null && h.this.cEN.isAdded()) {
                    if (h.this.cxO != null && h.this.cEN.aiW() != null && h.this.cEN.aiW().ajx() != null && !h.this.cEN.aiW().ajx().alF()) {
                        h.this.cxO.anX();
                    }
                    if (h.this.cxB != null && h.this.cOD != null && h.this.cxL != null && h.this.cxO != null) {
                        h.this.cEN.ajd();
                        h.this.cEN.eu(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.cEN.aiW() != null) {
                            h.this.cEN.aiW().cf(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.cEN.getListView().getVisibility() != 0 || v.v(h.this.cEN.ajn().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.cRu = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.g.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void v(float f) {
                if (h.this.cxB != null && (h.this.cxB.ajw() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cxB.ajw()).u(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kV() {
                if (h.this.cxB != null && (h.this.cxB.ajw() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cxB.ajw()).aoi();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kW() {
                if (h.this.cxB != null && h.this.cxB.ajv() != null) {
                    h.this.cxB.ajv().atu();
                }
                u.ZX().dA(false);
                com.baidu.tieba.tbadkCore.j ajn = h.this.cEN.ajn();
                if (h.this.cxB != null && ajn != null && h.this.cxK != null) {
                    if (j.hh()) {
                        if (h.this.cxB.ajw() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!(h.this.cxB.getListView() instanceof BdExpandListView) || !((BdExpandListView) h.this.cxB.getListView()).btB()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cxB.ajw()).kU();
                            }
                            h.this.cxB.cf(true);
                        }
                        TiebaStatic.eventStat(h.this.cEN.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (ajn.aPM() != null && ajn.gmI == 1) {
                            com.baidu.tieba.frs.e.b.a(ajn, h.this.cxK.anJ(), 1);
                        }
                        h.this.cEN.refresh();
                    } else if (h.this.cxB.ajw() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cxB.ajw()).aoi();
                    }
                    TiebaStatic.log(new ak("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.cEN.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.cxO = fVar.aiQ();
        fVar.registerListener(this.cRt);
    }

    public void a(i iVar, boolean z) {
        if (iVar != null) {
            iVar.eD(z);
            iVar.a(this.amz);
            iVar.a(this.amB);
            iVar.a(this.amA);
        }
    }
}
