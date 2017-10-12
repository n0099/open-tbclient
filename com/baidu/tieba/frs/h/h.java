package com.baidu.tieba.frs.h;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.card.u;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.view.BdExpandListView;
import tbclient.AlaLiveNotify;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private g.b amp;
    private g.a amq;
    private g.c amr;
    private final CustomMessageListener cIt;
    private final BdExpandListView.a cIu;
    private com.baidu.tieba.frs.smartsort.b cqG;

    public h(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cIt = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.h.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cqt != null) {
                    h.this.cqt.startPullRefresh();
                }
            }
        };
        this.amp = new g.b() { // from class: com.baidu.tieba.frs.h.h.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                if (h.this.cxi != null && h.this.cxi.isAdded()) {
                    h.this.cqt.ck(true);
                    if (j.hh()) {
                        h.this.cxi.refresh();
                        if (h.this.cqt != null) {
                            h.this.cxi.ez(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.cxi.agX();
                    }
                    TiebaStatic.log(new ak("c11749").ad("fid", h.this.cxi.getFid()).ad("obj_locate", "1"));
                }
            }
        };
        this.amr = new g.c() { // from class: com.baidu.tieba.frs.h.h.3
            @Override // com.baidu.tbadk.core.view.g.c
            public void aN(boolean z) {
                if (h.this.cqt != null && h.this.cFC != null && h.this.cqD != null && h.this.cxi != null && h.this.cxi.isAdded()) {
                    if (h.this.cqt != null && h.this.cqt.ahs() != null) {
                        h.this.cqt.ahs().ard();
                    }
                    h.this.cxi.ez(false);
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.h.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cqt.ahp() != null && h.this.cFC != null && h.this.cqt.ahp().getVisibility() != 0) {
                                h.this.cFC.GP();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.amq = new g.a() { // from class: com.baidu.tieba.frs.h.h.4
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (h.this.cxi != null && h.this.cxi.isAdded()) {
                    if (h.this.cqG != null && h.this.cxi.agU() != null && h.this.cxi.agU().ahu() != null && !h.this.cxi.agU().ahu().ajx()) {
                        h.this.cqG.alr();
                    }
                    if (h.this.cqt != null && h.this.cFC != null && h.this.cqD != null && h.this.cqG != null) {
                        AlaLiveNotify bqf = h.this.cxi.ahk().bqf();
                        if (bqf != null) {
                            new com.baidu.tieba.frs.d.a().a(h.this.cxi, bqf);
                        }
                        h.this.cxi.ez(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.cxi.agU() != null) {
                            h.this.cxi.agU().ck(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.cxi.getListView().getVisibility() != 0 || v.u(h.this.cxi.ahk().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.cIu = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.h.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void w(float f) {
                if (h.this.cqt != null && (h.this.cqt.aht() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cqt.aht()).v(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void lb() {
                if (h.this.cqt != null && (h.this.cqt.aht() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cqt.aht()).alC();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void lc() {
                if (h.this.cqt != null && h.this.cqt.ahs() != null) {
                    h.this.cqt.ahs().ard();
                }
                u.XR().dC(false);
                i ahk = h.this.cxi.ahk();
                if (h.this.cqt != null && ahk != null && h.this.cqC != null) {
                    if (j.hh()) {
                        if (h.this.cqt.aht() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!(h.this.cqt.getListView() instanceof BdExpandListView) || !((BdExpandListView) h.this.cqt.getListView()).bqC()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cqt.aht()).la();
                            }
                            h.this.cqt.ck(true);
                        }
                        TiebaStatic.eventStat(h.this.cxi.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (ahk.aMZ() != null && ahk.gek == 1) {
                            com.baidu.tieba.frs.f.b.a(ahk, h.this.cqC.ald(), 1);
                        }
                        h.this.cxi.refresh();
                    } else if (h.this.cqt.aht() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cqt.aht()).alC();
                    }
                    TiebaStatic.log(new ak("c11749").ad("fid", h.this.cxi.getFid()).ad("obj_locate", "1"));
                }
            }
        };
        this.cqG = fVar.agO();
        fVar.registerListener(this.cIt);
    }

    public void a(com.baidu.tieba.frs.i iVar, boolean z) {
        if (iVar != null) {
            iVar.eI(z);
            iVar.a(this.amp);
            iVar.a(this.amr);
            iVar.a(this.amq);
        }
    }
}
