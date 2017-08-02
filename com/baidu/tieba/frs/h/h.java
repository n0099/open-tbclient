package com.baidu.tieba.frs.h;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.view.BdExpandListView;
import tbclient.AlaLiveNotify;
/* loaded from: classes.dex */
public class h extends i {
    private k.b amt;
    private k.a amu;
    private k.c amv;
    private com.baidu.tieba.frs.smartsort.b cif;
    private com.baidu.tieba.d.a cwZ;
    private final CustomMessageListener cxa;
    private final BdExpandListView.a cxb;

    public h(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cxa = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.h.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.chQ != null) {
                    h.this.chQ.startPullRefresh();
                }
            }
        };
        this.amt = new k.b() { // from class: com.baidu.tieba.frs.h.h.2
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                h.this.cna.refresh();
                if (h.this.chQ != null) {
                    h.this.chQ.ck(true);
                    h.this.cna.eE(true);
                    TiebaStatic.log(new aj("c11749").aa("fid", h.this.cna.getFid()).aa("obj_locate", "1"));
                }
            }
        };
        this.amv = new k.c() { // from class: com.baidu.tieba.frs.h.h.3
            @Override // com.baidu.tbadk.core.view.k.c
            public void aN(boolean z) {
                if (h.this.chQ != null && h.this.ctU != null && h.this.cia != null) {
                    if (h.this.chQ != null && h.this.chQ.afu() != null) {
                        h.this.chQ.afu().apM();
                    }
                    h.this.cna.eE(false);
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.h.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.chQ.afr() != null && h.this.ctU != null && h.this.chQ.afr().getVisibility() != 0) {
                                h.this.ctU.He();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.amu = new k.a() { // from class: com.baidu.tieba.frs.h.h.4
            @Override // com.baidu.tbadk.core.view.k.a
            public void b(View view, boolean z) {
                if (h.this.cif != null && h.this.cna.aeU() != null && h.this.cna.aeU().afw() != null && !h.this.cna.aeU().afw().agY()) {
                    h.this.cif.aiG();
                }
                if (h.this.chQ != null && h.this.ctU != null && h.this.cia != null && h.this.cif != null) {
                    AlaLiveNotify brc = h.this.cna.afm().brc();
                    if (brc != null) {
                        new com.baidu.tieba.frs.d.a().a(h.this.cna, brc);
                    }
                    h.this.cna.eE(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                    if (TbadkCoreApplication.isLogin() && h.this.cna.getListView().getVisibility() == 0 && !u.v(h.this.cna.afm().getThreadList())) {
                        if (h.this.cwZ == null) {
                            h.this.cwZ = new com.baidu.tieba.d.a(h.this.cna.getPageContext(), h.this.chQ.VM());
                            h.this.cwZ.hH(d.g.story_frs_guide_bg);
                            h.this.cwZ.hK(1);
                            h.this.cwZ.hJ(500);
                            h.this.cwZ.hI(-1);
                            h.this.cwZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.h.4.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    if (h.this.cwZ != null) {
                                        h.this.cwZ.Yd();
                                    }
                                }
                            });
                        }
                        h.this.cwZ.jk("story_frs_guide_mask");
                    }
                }
            }
        };
        this.cxb = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.h.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void G(float f) {
                if (h.this.chQ != null && (h.this.chQ.afv() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.chQ.afv()).F(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kY() {
                if (h.this.chQ != null && (h.this.chQ.afv() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.chQ.afv()).aiQ();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void kZ() {
                if (h.this.chQ != null && h.this.chQ.afu() != null) {
                    h.this.chQ.afu().apM();
                }
                com.baidu.tieba.card.u.Ww().dE(false);
                com.baidu.tieba.tbadkCore.i afm = h.this.cna.afm();
                if (h.this.chQ != null && afm != null && h.this.chZ != null) {
                    if (com.baidu.adp.lib.util.i.hh()) {
                        if (h.this.chQ.afv() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!(h.this.chQ.getListView() instanceof BdExpandListView) || !((BdExpandListView) h.this.chQ.getListView()).brx()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.chQ.afv()).kX();
                            }
                            h.this.chQ.ck(true);
                        }
                        TiebaStatic.eventStat(h.this.cna.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (afm.aOW() != null && afm.gef == 1) {
                            com.baidu.tieba.frs.f.b.a(afm, h.this.chZ.ais(), 1);
                        }
                        h.this.cna.refresh();
                    } else if (h.this.chQ.afv() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.chQ.afv()).aiQ();
                    }
                    TiebaStatic.log(new aj("c11749").aa("fid", h.this.cna.getFid()).aa("obj_locate", "1"));
                }
            }
        };
        this.cif = fVar.aeO();
        fVar.registerListener(this.cxa);
    }

    public void a(com.baidu.tieba.frs.i iVar, boolean z) {
        if (iVar != null) {
            iVar.eM(z);
            iVar.a(this.amt);
            iVar.a(this.amv);
            iVar.a(this.amu);
        }
    }
}
