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
    private com.baidu.tieba.frs.smartsort.b cjY;

    public h(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cAs = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.g.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cjK != null) {
                    h.this.cjK.startPullRefresh();
                }
            }
        };
        this.anN = new k.b() { // from class: com.baidu.tieba.frs.g.h.2
            @Override // com.baidu.tbadk.core.view.k.b
            public void onListPullRefresh(boolean z) {
                if (h.this.coU != null && h.this.coU.isAdded()) {
                    h.this.coU.refresh();
                    if (h.this.cjK != null) {
                        h.this.cjK.ck(true);
                        h.this.coU.eG(true);
                        TiebaStatic.log(new aj("c11749").aa("fid", h.this.coU.getFid()).aa("obj_locate", "1"));
                    }
                }
            }
        };
        this.anP = new k.c() { // from class: com.baidu.tieba.frs.g.h.3
            @Override // com.baidu.tbadk.core.view.k.c
            public void aN(boolean z) {
                if (h.this.cjK != null && h.this.cxp != null && h.this.cjU != null && h.this.coU != null && h.this.coU.isAdded()) {
                    if (h.this.cjK != null && h.this.cjK.afW() != null) {
                        h.this.cjK.afW().aqF();
                    }
                    h.this.coU.eG(false);
                    com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.g.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cjK.afT() != null && h.this.cxp != null && h.this.cjK.afT().getVisibility() != 0) {
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
                if (h.this.coU != null && h.this.coU.isAdded()) {
                    if (h.this.cjY != null && h.this.coU.afv() != null && h.this.coU.afv().afY() != null && !h.this.coU.afv().afY().ahA()) {
                        h.this.cjY.ajz();
                    }
                    if (h.this.cjK != null && h.this.cxp != null && h.this.cjU != null && h.this.cjY != null) {
                        AlaLiveNotify brR = h.this.coU.afN().brR();
                        if (brR != null) {
                            new com.baidu.tieba.frs.c.a().a(h.this.coU, brR);
                        }
                        h.this.coU.eG(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (TbadkCoreApplication.isLogin() && h.this.coU.getListView().getVisibility() == 0 && !u.v(h.this.coU.afN().getThreadList())) {
                            if (h.this.cAr == null) {
                                h.this.cAr = new com.baidu.tieba.d.a(h.this.coU.getPageContext(), h.this.cjK.Wn());
                                h.this.cAr.hJ(d.g.story_frs_guide_bg);
                                h.this.cAr.hM(1);
                                h.this.cAr.hL(500);
                                h.this.cAr.hK(-1);
                                h.this.cAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.h.4.1
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        if (h.this.cAr != null) {
                                            h.this.cAr.YD();
                                        }
                                    }
                                });
                            }
                            h.this.cAr.jq("story_frs_guide_mask");
                        }
                    }
                }
            }
        };
        this.cAt = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.g.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void G(float f) {
                if (h.this.cjK != null && (h.this.cjK.afX() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cjK.afX()).F(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void li() {
                if (h.this.cjK != null && (h.this.cjK.afX() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cjK.afX()).ajJ();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void lj() {
                if (h.this.cjK != null && h.this.cjK.afW() != null) {
                    h.this.cjK.afW().aqF();
                }
                com.baidu.tieba.card.u.WX().dF(false);
                com.baidu.tieba.tbadkCore.i afN = h.this.coU.afN();
                if (h.this.cjK != null && afN != null && h.this.cjT != null) {
                    if (com.baidu.adp.lib.util.i.hr()) {
                        if (h.this.cjK.afX() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!(h.this.cjK.getListView() instanceof BdExpandListView) || !((BdExpandListView) h.this.cjK.getListView()).bsm()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cjK.afX()).lh();
                            }
                            h.this.cjK.ck(true);
                        }
                        TiebaStatic.eventStat(h.this.coU.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (afN.aPO() != null && afN.ghi == 1) {
                            com.baidu.tieba.frs.e.b.a(afN, h.this.cjT.ajl(), 1);
                        }
                        h.this.coU.refresh();
                    } else if (h.this.cjK.afX() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cjK.afX()).ajJ();
                    }
                    TiebaStatic.log(new aj("c11749").aa("fid", h.this.coU.getFid()).aa("obj_locate", "1"));
                }
            }
        };
        this.cjY = fVar.afp();
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
