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
    private k.b anf;
    private k.a ang;
    private k.c anh;
    private final CustomMessageListener cHD;
    private final BdExpandListView.a cHE;
    private com.baidu.tieba.frs.smartsort.b cqk;

    public h(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cHD = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.h.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cpW != null) {
                    h.this.cpW.startPullRefresh();
                }
            }
        };
        this.anf = new k.b() { // from class: com.baidu.tieba.frs.h.h.2
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                if (h.this.cws != null && h.this.cws.isAdded()) {
                    h.this.cpW.cl(true);
                    if (com.baidu.adp.lib.util.i.hi()) {
                        h.this.cws.refresh();
                        if (h.this.cpW != null) {
                            h.this.cws.eJ(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.cws.ahb();
                    }
                    TiebaStatic.log(new ak("c11749").ad("fid", h.this.cws.getFid()).ad("obj_locate", "1"));
                }
            }
        };
        this.anh = new k.c() { // from class: com.baidu.tieba.frs.h.h.3
            @Override // com.baidu.tbadk.core.view.k.c
            public void aN(boolean z) {
                if (h.this.cpW != null && h.this.cEJ != null && h.this.cqg != null && h.this.cws != null && h.this.cws.isAdded()) {
                    if (h.this.cpW != null && h.this.cpW.ahz() != null) {
                        h.this.cpW.ahz().asu();
                    }
                    h.this.cws.eJ(false);
                    com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.h.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cpW.ahw() != null && h.this.cEJ != null && h.this.cpW.ahw().getVisibility() != 0) {
                                h.this.cEJ.Hl();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.ang = new k.a() { // from class: com.baidu.tieba.frs.h.h.4
            @Override // com.baidu.tbadk.core.view.k.a
            public void b(View view, boolean z) {
                if (h.this.cws != null && h.this.cws.isAdded()) {
                    if (h.this.cqk != null && h.this.cws.agY() != null && h.this.cws.agY().ahB() != null && !h.this.cws.agY().ahB().ajs()) {
                        h.this.cqk.aln();
                    }
                    if (h.this.cpW != null && h.this.cEJ != null && h.this.cqg != null && h.this.cqk != null) {
                        AlaLiveNotify brk = h.this.cws.ahq().brk();
                        if (brk != null) {
                            new com.baidu.tieba.frs.d.a().a(h.this.cws, brk);
                        }
                        h.this.cws.eJ(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.cws.agY() != null) {
                            h.this.cws.agY().cl(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.cws.getListView().getVisibility() != 0 || v.v(h.this.cws.ahq().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.cHE = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.h.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void v(float f) {
                if (h.this.cpW != null && (h.this.cpW.ahA() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cpW.ahA()).u(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kZ() {
                if (h.this.cpW != null && (h.this.cpW.ahA() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cpW.ahA()).aly();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void la() {
                if (h.this.cpW != null && h.this.cpW.ahz() != null) {
                    h.this.cpW.ahz().asu();
                }
                u.Yj().dJ(false);
                com.baidu.tieba.tbadkCore.i ahq = h.this.cws.ahq();
                if (h.this.cpW != null && ahq != null && h.this.cqf != null) {
                    if (com.baidu.adp.lib.util.i.hi()) {
                        if (h.this.cpW.ahA() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!(h.this.cpW.getListView() instanceof BdExpandListView) || !((BdExpandListView) h.this.cpW.getListView()).brF()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cpW.ahA()).kY();
                            }
                            h.this.cpW.cl(true);
                        }
                        TiebaStatic.eventStat(h.this.cws.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (ahq.aPg() != null && ahq.ggE == 1) {
                            com.baidu.tieba.frs.f.b.a(ahq, h.this.cqf.akZ(), 1);
                        }
                        h.this.cws.refresh();
                    } else if (h.this.cpW.ahA() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cpW.ahA()).aly();
                    }
                    TiebaStatic.log(new ak("c11749").ad("fid", h.this.cws.getFid()).ad("obj_locate", "1"));
                }
            }
        };
        this.cqk = fVar.agS();
        fVar.registerListener(this.cHD);
    }

    public void a(com.baidu.tieba.frs.i iVar, boolean z) {
        if (iVar != null) {
            iVar.eS(z);
            iVar.a(this.anf);
            iVar.a(this.anh);
            iVar.a(this.ang);
        }
    }
}
