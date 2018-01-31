package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.card.s;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.view.a;
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private j.b baZ;
    private j.a bba;
    private j.c bbb;
    private com.baidu.tieba.frs.smartsort.b dBP;
    private final CustomMessageListener dSu;
    private final a.InterfaceC0167a dSv;

    public h(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dSu = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.f.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dBD != null) {
                    h.this.dBD.startPullRefresh();
                }
            }
        };
        this.baZ = new j.b() { // from class: com.baidu.tieba.frs.f.h.2
            @Override // com.baidu.tbadk.core.view.j.b
            public void onListPullRefresh(boolean z) {
                if (h.this.dPK != null && h.this.dPK.isAdded()) {
                    h.this.dBD.cM(true);
                    if (com.baidu.adp.lib.util.j.oJ()) {
                        h.this.dPK.refresh();
                        if (h.this.dBD != null) {
                            h.this.dPK.fD(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dPK.aug();
                    }
                    TiebaStatic.log(new ak("c11749").aa(ImageViewerConfig.FORUM_ID, h.this.dPK.getFid()).aa("obj_locate", "1"));
                }
            }
        };
        this.bbb = new j.c() { // from class: com.baidu.tieba.frs.f.h.3
            @Override // com.baidu.tbadk.core.view.j.c
            public void bs(boolean z) {
                if (h.this.dBD != null && h.this.dQF != null && h.this.dBM != null && h.this.dPK != null && h.this.dPK.isAdded()) {
                    if (h.this.dBD != null && h.this.dBD.auE() != null) {
                        h.this.dBD.auE().aCG();
                    }
                    h.this.dPK.fD(false);
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.f.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dBD.auB() != null && h.this.dQF != null && h.this.dBD.auB().getVisibility() != 0) {
                                h.this.dQF.OD();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.bba = new j.a() { // from class: com.baidu.tieba.frs.f.h.4
            @Override // com.baidu.tbadk.core.view.j.a
            public void i(View view, boolean z) {
                if (h.this.dPK != null && h.this.dPK.isAdded()) {
                    if (h.this.dBP != null && h.this.dPK.aud() != null && h.this.dPK.aud().auG() != null && !h.this.dPK.aud().auG().awF()) {
                        h.this.dBP.ayJ();
                    }
                    if (h.this.dBD != null && h.this.dQF != null && h.this.dBM != null && h.this.dBP != null) {
                        h.this.dPK.auk();
                        h.this.dPK.fD(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.dPK.aud() != null) {
                            h.this.dPK.aud().cM(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dPK.Ee().getVisibility() != 0 || v.E(h.this.dPK.auv().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dSv = new a.InterfaceC0167a() { // from class: com.baidu.tieba.frs.f.h.5
            @Override // com.baidu.tieba.view.a.InterfaceC0167a
            public void L(float f) {
                if (h.this.dBD != null && (h.this.dBD.auF() instanceof com.baidu.tieba.frs.tab.a)) {
                    ((com.baidu.tieba.frs.tab.a) h.this.dBD.auF()).K(f);
                }
            }

            @Override // com.baidu.tieba.view.a.InterfaceC0167a
            public void su() {
                if (h.this.dBD != null && (h.this.dBD.auF() instanceof com.baidu.tieba.frs.tab.a)) {
                    ((com.baidu.tieba.frs.tab.a) h.this.dBD.auF()).ayR();
                }
            }

            @Override // com.baidu.tieba.view.a.InterfaceC0167a
            public void onRefresh() {
                if (h.this.dBD != null && h.this.dBD.auE() != null) {
                    h.this.dBD.auE().aCG();
                }
                s.akK().eH(false);
                l auv = h.this.dPK.auv();
                if (h.this.dBD != null && auv != null && h.this.dBL != null) {
                    if (com.baidu.adp.lib.util.j.oJ()) {
                        if (h.this.dBD.auF() instanceof com.baidu.tieba.frs.tab.a) {
                            if (!auv.buP()) {
                                ((com.baidu.tieba.frs.tab.a) h.this.dBD.auF()).st();
                            }
                            h.this.dBD.cM(true);
                        }
                        TiebaStatic.eventStat(h.this.dPK.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (auv.aYJ() != null && auv.gVW == 1) {
                            com.baidu.tieba.frs.d.b.a(auv, h.this.dBL.ayv(), 1);
                        }
                        h.this.dPK.refresh();
                    } else if (h.this.dBD.auF() instanceof com.baidu.tieba.frs.tab.a) {
                        ((com.baidu.tieba.frs.tab.a) h.this.dBD.auF()).ayR();
                    }
                    TiebaStatic.log(new ak("c11749").aa(ImageViewerConfig.FORUM_ID, h.this.dPK.getFid()).aa("obj_locate", "1"));
                }
            }
        };
        this.dBP = iVar.atX();
        iVar.registerListener(this.dSu);
    }

    public void a(com.baidu.tieba.frs.k kVar, boolean z) {
        if (kVar != null) {
            kVar.fM(z);
            kVar.a(this.baZ);
            kVar.a(this.bbb);
            kVar.a(this.bba);
        }
    }
}
