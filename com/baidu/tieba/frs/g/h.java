package com.baidu.tieba.frs.g;

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
    private k.b anN;
    private k.a anO;
    private k.c anP;
    private com.baidu.tieba.d.a cAr;
    private final CustomMessageListener cAs;
    private final BdExpandListView.a cAt;
    private com.baidu.tieba.frs.smartsort.b cjZ;

    public h(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cAs = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.g.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cjL != null) {
                    h.this.cjL.startPullRefresh();
                }
            }
        };
        this.anN = new k.b() { // from class: com.baidu.tieba.frs.g.h.2
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                if (h.this.coV != null && h.this.coV.isAdded()) {
                    h.this.coV.refresh();
                    if (h.this.cjL != null) {
                        h.this.cjL.ck(true);
                        h.this.coV.eG(true);
                        TiebaStatic.log(new aj("c11749").aa("fid", h.this.coV.getFid()).aa("obj_locate", "1"));
                    }
                }
            }
        };
        this.anP = new k.c() { // from class: com.baidu.tieba.frs.g.h.3
            @Override // com.baidu.tbadk.core.view.k.c
            public void aN(boolean z) {
                if (h.this.cjL != null && h.this.cxp != null && h.this.cjV != null && h.this.coV != null && h.this.coV.isAdded()) {
                    if (h.this.cjL != null && h.this.cjL.afQ() != null) {
                        h.this.cjL.afQ().aqz();
                    }
                    h.this.coV.eG(false);
                    com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cjL.afN() != null && h.this.cxp != null && h.this.cjL.afN().getVisibility() != 0) {
                                h.this.cxp.Hm();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.anO = new k.a() { // from class: com.baidu.tieba.frs.g.h.4
            @Override // com.baidu.tbadk.core.view.k.a
            public void b(View view, boolean z) {
                if (h.this.coV != null && h.this.coV.isAdded()) {
                    if (h.this.cjZ != null && h.this.coV.afp() != null && h.this.coV.afp().afS() != null && !h.this.coV.afp().afS().ahu()) {
                        h.this.cjZ.ajt();
                    }
                    if (h.this.cjL != null && h.this.cxp != null && h.this.cjV != null && h.this.cjZ != null) {
                        AlaLiveNotify brK = h.this.coV.afH().brK();
                        if (brK != null) {
                            new com.baidu.tieba.frs.c.a().a(h.this.coV, brK);
                        }
                        h.this.coV.eG(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (TbadkCoreApplication.isLogin() && h.this.coV.getListView().getVisibility() == 0 && !u.v(h.this.coV.afH().getThreadList())) {
                            if (h.this.cAr == null) {
                                h.this.cAr = new com.baidu.tieba.d.a(h.this.coV.getPageContext(), h.this.cjL.Wk());
                                h.this.cAr.hJ(d.g.story_frs_guide_bg);
                                h.this.cAr.hM(1);
                                h.this.cAr.hL(500);
                                h.this.cAr.hK(-1);
                                h.this.cAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.h.4.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.cAr != null) {
                                            h.this.cAr.YA();
                                        }
                                    }
                                });
                            }
                            h.this.cAr.jt("story_frs_guide_mask");
                        }
                    }
                }
            }
        };
        this.cAt = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.g.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void G(float f) {
                if (h.this.cjL != null && (h.this.cjL.afR() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cjL.afR()).F(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void lh() {
                if (h.this.cjL != null && (h.this.cjL.afR() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cjL.afR()).ajD();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void li() {
                if (h.this.cjL != null && h.this.cjL.afQ() != null) {
                    h.this.cjL.afQ().aqz();
                }
                com.baidu.tieba.card.u.WU().dF(false);
                com.baidu.tieba.tbadkCore.i afH = h.this.coV.afH();
                if (h.this.cjL != null && afH != null && h.this.cjU != null) {
                    if (com.baidu.adp.lib.util.i.hr()) {
                        if (h.this.cjL.afR() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!(h.this.cjL.getListView() instanceof BdExpandListView) || !((BdExpandListView) h.this.cjL.getListView()).bsf()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cjL.afR()).lg();
                            }
                            h.this.cjL.ck(true);
                        }
                        TiebaStatic.eventStat(h.this.coV.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (afH.aPJ() != null && afH.ghi == 1) {
                            com.baidu.tieba.frs.e.b.a(afH, h.this.cjU.ajf(), 1);
                        }
                        h.this.coV.refresh();
                    } else if (h.this.cjL.afR() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cjL.afR()).ajD();
                    }
                    TiebaStatic.log(new aj("c11749").aa("fid", h.this.coV.getFid()).aa("obj_locate", "1"));
                }
            }
        };
        this.cjZ = fVar.afj();
        fVar.registerListener(this.cAs);
    }

    public void a(com.baidu.tieba.frs.i iVar, boolean z) {
        if (iVar != null) {
            iVar.eO(z);
            iVar.a(this.anN);
            iVar.a(this.anP);
            iVar.a(this.anO);
        }
    }
}
