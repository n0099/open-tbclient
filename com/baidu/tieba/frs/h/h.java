package com.baidu.tieba.frs.h;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.card.u;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.view.BdExpandListView;
import tbclient.AlaLiveNotify;
/* loaded from: classes.dex */
public class h extends i {
    private k.b anh;
    private k.a ani;
    private k.c anj;
    private final CustomMessageListener cGJ;
    private final BdExpandListView.a cGK;
    private com.baidu.tieba.frs.smartsort.b cps;

    public h(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cGJ = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.h.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cpe != null) {
                    h.this.cpe.startPullRefresh();
                }
            }
        };
        this.anh = new k.b() { // from class: com.baidu.tieba.frs.h.h.2
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                if (h.this.cvA != null && h.this.cvA.isAdded()) {
                    h.this.cpe.cl(true);
                    if (com.baidu.adp.lib.util.i.hi()) {
                        h.this.cvA.refresh();
                        if (h.this.cpe != null) {
                            h.this.cvA.eI(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.cvA.agQ();
                    }
                    TiebaStatic.log(new ak("c11749").ad("fid", h.this.cvA.getFid()).ad("obj_locate", "1"));
                }
            }
        };
        this.anj = new k.c() { // from class: com.baidu.tieba.frs.h.h.3
            @Override // com.baidu.tbadk.core.view.k.c
            public void aN(boolean z) {
                if (h.this.cpe != null && h.this.cDR != null && h.this.cpo != null && h.this.cvA != null && h.this.cvA.isAdded()) {
                    if (h.this.cpe != null && h.this.cpe.aho() != null) {
                        h.this.cpe.aho().asj();
                    }
                    h.this.cvA.eI(false);
                    com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.h.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cpe.ahl() != null && h.this.cDR != null && h.this.cpe.ahl().getVisibility() != 0) {
                                h.this.cDR.Hl();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.ani = new k.a() { // from class: com.baidu.tieba.frs.h.h.4
            @Override // com.baidu.tbadk.core.view.k.a
            public void b(View view, boolean z) {
                if (h.this.cvA != null && h.this.cvA.isAdded()) {
                    if (h.this.cps != null && h.this.cvA.agN() != null && h.this.cvA.agN().ahq() != null && !h.this.cvA.agN().ahq().ajh()) {
                        h.this.cps.alc();
                    }
                    if (h.this.cpe != null && h.this.cDR != null && h.this.cpo != null && h.this.cps != null) {
                        AlaLiveNotify bqZ = h.this.cvA.ahf().bqZ();
                        if (bqZ != null) {
                            new com.baidu.tieba.frs.d.a().a(h.this.cvA, bqZ);
                        }
                        h.this.cvA.eI(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.cvA.agN() != null) {
                            h.this.cvA.agN().cl(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.cvA.getListView().getVisibility() != 0 || v.v(h.this.cvA.ahf().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.cGK = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.h.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void v(float f) {
                if (h.this.cpe != null && (h.this.cpe.ahp() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cpe.ahp()).u(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kZ() {
                if (h.this.cpe != null && (h.this.cpe.ahp() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cpe.ahp()).aln();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void la() {
                if (h.this.cpe != null && h.this.cpe.aho() != null) {
                    h.this.cpe.aho().asj();
                }
                u.XY().dI(false);
                com.baidu.tieba.tbadkCore.i ahf = h.this.cvA.ahf();
                if (h.this.cpe != null && ahf != null && h.this.cpn != null) {
                    if (com.baidu.adp.lib.util.i.hi()) {
                        if (h.this.cpe.ahp() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!(h.this.cpe.getListView() instanceof BdExpandListView) || !((BdExpandListView) h.this.cpe.getListView()).bru()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cpe.ahp()).kY();
                            }
                            h.this.cpe.cl(true);
                        }
                        TiebaStatic.eventStat(h.this.cvA.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (ahf.aOV() != null && ahf.gfK == 1) {
                            com.baidu.tieba.frs.f.b.a(ahf, h.this.cpn.akO(), 1);
                        }
                        h.this.cvA.refresh();
                    } else if (h.this.cpe.ahp() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cpe.ahp()).aln();
                    }
                    TiebaStatic.log(new ak("c11749").ad("fid", h.this.cvA.getFid()).ad("obj_locate", "1"));
                }
            }
        };
        this.cps = fVar.agH();
        fVar.registerListener(this.cGJ);
    }

    public void a(com.baidu.tieba.frs.i iVar, boolean z) {
        if (iVar != null) {
            iVar.eR(z);
            iVar.a(this.anh);
            iVar.a(this.anj);
            iVar.a(this.ani);
        }
    }
}
