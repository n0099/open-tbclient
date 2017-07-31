package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.card.u;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.view.BdExpandListView;
import tbclient.AlaLiveNotify;
/* loaded from: classes.dex */
public class h extends i {
    private k.b anM;
    private k.a anN;
    private k.c anO;
    private com.baidu.tieba.frs.smartsort.b cjl;
    private final CustomMessageListener cyt;
    private final BdExpandListView.a cyu;

    public h(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cyt = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.g.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.ciX != null) {
                    h.this.ciX.startPullRefresh();
                }
            }
        };
        this.anM = new k.b() { // from class: com.baidu.tieba.frs.g.h.2
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                h.this.f5com.refresh();
                if (h.this.ciX != null) {
                    h.this.ciX.ck(true);
                    h.this.f5com.eE(true);
                    TiebaStatic.log(new aj("c11749").aa("fid", h.this.f5com.getFid()).aa("obj_locate", "1"));
                }
            }
        };
        this.anO = new k.c() { // from class: com.baidu.tieba.frs.g.h.3
            @Override // com.baidu.tbadk.core.view.k.c
            public void aN(boolean z) {
                if (h.this.ciX != null && h.this.cvm != null && h.this.cjh != null) {
                    if (h.this.ciX != null && h.this.ciX.afz() != null) {
                        h.this.ciX.afz().apY();
                    }
                    h.this.f5com.eE(false);
                    com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.ciX.afw() != null && h.this.cvm != null && h.this.ciX.afw().getVisibility() != 0) {
                                h.this.cvm.Hm();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.anN = new k.a() { // from class: com.baidu.tieba.frs.g.h.4
            @Override // com.baidu.tbadk.core.view.k.a
            public void b(View view, boolean z) {
                h.this.ajI();
            }
        };
        this.cyu = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.g.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void G(float f) {
                if (h.this.ciX != null && (h.this.ciX.afA() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.ciX.afA()).F(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void li() {
                if (h.this.ciX != null && (h.this.ciX.afA() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.ciX.afA()).ajc();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void lj() {
                if (h.this.ciX != null && h.this.ciX.afz() != null) {
                    h.this.ciX.afz().apY();
                }
                u.WB().dE(false);
                com.baidu.tieba.tbadkCore.i afr = h.this.f5com.afr();
                if (h.this.ciX != null && afr != null && h.this.cjg != null) {
                    if (com.baidu.adp.lib.util.i.hr()) {
                        if (h.this.ciX.afA() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!(h.this.ciX.getListView() instanceof BdExpandListView) || !((BdExpandListView) h.this.ciX.getListView()).brE()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.ciX.afA()).lh();
                            }
                            h.this.ciX.ck(true);
                        }
                        TiebaStatic.eventStat(h.this.f5com.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (afr.aPh() != null && afr.gfq == 1) {
                            com.baidu.tieba.frs.e.b.a(afr, h.this.cjg.aiE(), 1);
                        }
                        h.this.f5com.refresh();
                    } else if (h.this.ciX.afA() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.ciX.afA()).ajc();
                    }
                    TiebaStatic.log(new aj("c11749").aa("fid", h.this.f5com.getFid()).aa("obj_locate", "1"));
                }
            }
        };
        this.cjl = fVar.aeT();
        this.ciX.a(this.cyu);
        fVar.registerListener(this.cyt);
    }

    public void a(com.baidu.tieba.frs.i iVar, boolean z) {
        if (iVar != null) {
            iVar.afV();
            iVar.a(this.cyu);
        }
    }

    public void ajI() {
        if (this.cjl != null && this.f5com.aeZ() != null && this.f5com.aeZ().afB() != null && !this.f5com.aeZ().afB().ahf()) {
            this.cjl.aiS();
        }
        if (this.ciX != null && this.cvm != null && this.cjh != null && this.cjl != null) {
            AlaLiveNotify brj = this.f5com.afr().brj();
            if (brj != null) {
                new com.baidu.tieba.frs.c.a().a(this.f5com, brj);
            }
            this.f5com.eE(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
        }
    }
}
