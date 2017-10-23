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
    private g.b amd;
    private g.a ame;
    private g.c amf;
    private final CustomMessageListener cIh;
    private final BdExpandListView.a cIi;
    private com.baidu.tieba.frs.smartsort.b cqu;

    public h(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cIh = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.h.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cqh != null) {
                    h.this.cqh.startPullRefresh();
                }
            }
        };
        this.amd = new g.b() { // from class: com.baidu.tieba.frs.h.h.2
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefresh(boolean z) {
                if (h.this.cwW != null && h.this.cwW.isAdded()) {
                    h.this.cqh.cj(true);
                    if (j.hh()) {
                        h.this.cwW.refresh();
                        if (h.this.cqh != null) {
                            h.this.cwW.ey(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.cwW.agS();
                    }
                    TiebaStatic.log(new ak("c11749").ac("fid", h.this.cwW.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.amf = new g.c() { // from class: com.baidu.tieba.frs.h.h.3
            @Override // com.baidu.tbadk.core.view.g.c
            public void aM(boolean z) {
                if (h.this.cqh != null && h.this.cFq != null && h.this.cqr != null && h.this.cwW != null && h.this.cwW.isAdded()) {
                    if (h.this.cqh != null && h.this.cqh.ahn() != null) {
                        h.this.cqh.ahn().aqY();
                    }
                    h.this.cwW.ey(false);
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.h.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cqh.ahk() != null && h.this.cFq != null && h.this.cqh.ahk().getVisibility() != 0) {
                                h.this.cFq.GJ();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.ame = new g.a() { // from class: com.baidu.tieba.frs.h.h.4
            @Override // com.baidu.tbadk.core.view.g.a
            public void b(View view, boolean z) {
                if (h.this.cwW != null && h.this.cwW.isAdded()) {
                    if (h.this.cqu != null && h.this.cwW.agP() != null && h.this.cwW.agP().ahp() != null && !h.this.cwW.agP().ahp().ajs()) {
                        h.this.cqu.alm();
                    }
                    if (h.this.cqh != null && h.this.cFq != null && h.this.cqr != null && h.this.cqu != null) {
                        AlaLiveNotify bpY = h.this.cwW.ahf().bpY();
                        if (bpY != null) {
                            new com.baidu.tieba.frs.d.a().a(h.this.cwW, bpY);
                        }
                        h.this.cwW.ey(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.cwW.agP() != null) {
                            h.this.cwW.agP().cj(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.cwW.getListView().getVisibility() != 0 || v.u(h.this.cwW.ahf().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.cIi = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.h.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void w(float f) {
                if (h.this.cqh != null && (h.this.cqh.aho() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cqh.aho()).v(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void lb() {
                if (h.this.cqh != null && (h.this.cqh.aho() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cqh.aho()).alx();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void lc() {
                if (h.this.cqh != null && h.this.cqh.ahn() != null) {
                    h.this.cqh.ahn().aqY();
                }
                u.XN().dB(false);
                i ahf = h.this.cwW.ahf();
                if (h.this.cqh != null && ahf != null && h.this.cqq != null) {
                    if (j.hh()) {
                        if (h.this.cqh.aho() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!(h.this.cqh.getListView() instanceof BdExpandListView) || !((BdExpandListView) h.this.cqh.getListView()).bqv()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cqh.aho()).la();
                            }
                            h.this.cqh.cj(true);
                        }
                        TiebaStatic.eventStat(h.this.cwW.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (ahf.aMU() != null && ahf.gdW == 1) {
                            com.baidu.tieba.frs.f.b.a(ahf, h.this.cqq.akY(), 1);
                        }
                        h.this.cwW.refresh();
                    } else if (h.this.cqh.aho() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cqh.aho()).alx();
                    }
                    TiebaStatic.log(new ak("c11749").ac("fid", h.this.cwW.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.cqu = fVar.agJ();
        fVar.registerListener(this.cIh);
    }

    public void a(com.baidu.tieba.frs.i iVar, boolean z) {
        if (iVar != null) {
            iVar.eH(z);
            iVar.a(this.amd);
            iVar.a(this.amf);
            iVar.a(this.ame);
        }
    }
}
