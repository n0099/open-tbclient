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
    private h.b amR;
    private h.a amS;
    private h.c amT;
    private com.baidu.tieba.frs.smartsort.b cHu;
    private final CustomMessageListener dbf;
    private final BdExpandListView.a dbg;

    public h(com.baidu.tieba.frs.g gVar) {
        super(gVar);
        this.dbf = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.g.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cHi != null) {
                    h.this.cHi.startPullRefresh();
                }
            }
        };
        this.amR = new h.b() { // from class: com.baidu.tieba.frs.g.h.2
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefresh(boolean z) {
                if (h.this.cOx != null && h.this.cOx.isAdded()) {
                    h.this.cHi.ck(true);
                    if (j.hh()) {
                        h.this.cOx.refresh();
                        if (h.this.cHi != null) {
                            h.this.cOx.eR(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.cOx.alr();
                    }
                    TiebaStatic.log(new ak("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.cOx.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.amT = new h.c() { // from class: com.baidu.tieba.frs.g.h.3
            @Override // com.baidu.tbadk.core.view.h.c
            public void aL(boolean z) {
                if (h.this.cHi != null && h.this.cYy != null && h.this.cHr != null && h.this.cOx != null && h.this.cOx.isAdded()) {
                    if (h.this.cHi != null && h.this.cHi.alM() != null) {
                        h.this.cHi.alM().avu();
                    }
                    h.this.cOx.eR(false);
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cHi.alJ() != null && h.this.cYy != null && h.this.cHi.alJ().getVisibility() != 0) {
                                h.this.cYy.Ho();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.amS = new h.a() { // from class: com.baidu.tieba.frs.g.h.4
            @Override // com.baidu.tbadk.core.view.h.a
            public void b(View view, boolean z) {
                if (h.this.cOx != null && h.this.cOx.isAdded()) {
                    if (h.this.cHu != null && h.this.cOx.alo() != null && h.this.cOx.alo().alO() != null && !h.this.cOx.alo().alO().anX()) {
                        h.this.cHu.aqp();
                    }
                    if (h.this.cHi != null && h.this.cYy != null && h.this.cHr != null && h.this.cHu != null) {
                        h.this.cOx.alv();
                        h.this.cOx.eR(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.cOx.alo() != null) {
                            h.this.cOx.alo().ck(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.cOx.getListView().getVisibility() != 0 || v.w(h.this.cOx.alF().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dbg = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.g.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void v(float f) {
                if (h.this.cHi != null && (h.this.cHi.alN() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cHi.alN()).u(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kV() {
                if (h.this.cHi != null && (h.this.cHi.alN() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cHi.alN()).aqA();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kW() {
                if (h.this.cHi != null && h.this.cHi.alM() != null) {
                    h.this.cHi.alM().avu();
                }
                s.abX().dU(false);
                k alF = h.this.cOx.alF();
                if (h.this.cHi != null && alF != null && h.this.cHq != null) {
                    if (j.hh()) {
                        if (h.this.cHi.alN() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!(h.this.cHi.getListView() instanceof BdExpandListView) || !((BdExpandListView) h.this.cHi.getListView()).bwc()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cHi.alN()).kU();
                            }
                            h.this.cHi.ck(true);
                        }
                        TiebaStatic.eventStat(h.this.cOx.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (alF.aRo() != null && alF.gzl == 1) {
                            com.baidu.tieba.frs.e.b.a(alF, h.this.cHq.aqb(), 1);
                        }
                        h.this.cOx.refresh();
                    } else if (h.this.cHi.alN() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cHi.alN()).aqA();
                    }
                    TiebaStatic.log(new ak("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.cOx.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.cHu = gVar.ali();
        gVar.registerListener(this.dbf);
    }

    public void a(com.baidu.tieba.frs.j jVar, boolean z) {
        if (jVar != null) {
            jVar.fa(z);
            jVar.a(this.amR);
            jVar.a(this.amT);
            jVar.a(this.amS);
        }
    }
}
