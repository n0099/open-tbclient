package com.baidu.tieba.frs.vc;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private e.b anZ;
    private e.a aoa;
    private e.c aob;
    private com.baidu.tieba.frs.smartsort.b cYA;
    private boolean drJ;
    private final CustomMessageListener drK;
    private final BdExpandListView.a drL;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.drJ = false;
        this.drK = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.cYo != null) {
                    h.this.cYo.startPullRefresh();
                }
            }
        };
        this.anZ = new e.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (h.this.dof != null && h.this.dof.isAdded()) {
                    h.this.cYo.ch(true);
                    if (com.baidu.adp.lib.util.j.gP()) {
                        h.this.dof.refresh();
                        if (h.this.cYo != null) {
                            h.this.dof.fq(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dof.app();
                    }
                    TiebaStatic.log(new al("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.dof.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.aob = new e.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.e.c
            public void aP(boolean z) {
                h.this.drJ = true;
                if (h.this.cYo != null && h.this.dpc != null && h.this.cYx != null && h.this.dof != null && h.this.dof.isAdded()) {
                    if (h.this.cYo != null && h.this.cYo.aqb() != null) {
                        h.this.cYo.aqb().ayY();
                    }
                    h.this.dof.fq(false);
                    com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.cYo.apO() != null && h.this.dpc != null && h.this.cYo.apO().getVisibility() != 0) {
                                h.this.dpc.HI();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.aoa = new e.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.e.a
            public void c(View view2, boolean z) {
                if (h.this.dof != null && h.this.dof.isAdded()) {
                    if (h.this.drJ && h.this.dof.apk() != null) {
                        h.this.dof.apk().avt();
                        h.this.drJ = false;
                    }
                    if (h.this.cYA != null && h.this.dof.apm() != null && h.this.dof.apm().aqd() != null && !h.this.dof.apm().aqd().asc()) {
                        h.this.cYA.auB();
                    }
                    if (h.this.cYo != null && h.this.dpc != null && h.this.cYx != null && h.this.cYA != null) {
                        h.this.dof.apt();
                        h.this.dof.fq(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dof.apm() != null) {
                            h.this.dof.apm().ch(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dof.xi().getVisibility() != 0 || v.w(h.this.dof.apD().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.drL = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void D(float f) {
                if (h.this.cYo != null && (h.this.cYo.aqc() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cYo.aqc()).C(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void ky() {
                if (h.this.cYo != null && (h.this.cYo.aqc() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.cYo.aqc()).auK();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.cYo != null && h.this.cYo.aqb() != null) {
                    h.this.cYo.aqb().ayY();
                }
                com.baidu.tieba.card.v.afy().eu(false);
                l apD = h.this.dof.apD();
                if (h.this.cYo != null && apD != null && h.this.cYw != null) {
                    if (com.baidu.adp.lib.util.j.gP()) {
                        if (h.this.cYo.aqc() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!apD.brh()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.cYo.aqc()).kx();
                            }
                            h.this.cYo.ch(true);
                        }
                        TiebaStatic.eventStat(h.this.dof.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (apD.aVq() != null && apD.guT == 1) {
                            com.baidu.tieba.frs.e.b.a(apD, h.this.cYw.aum(), 1);
                        }
                        h.this.dof.refresh();
                    } else if (h.this.cYo.aqc() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.cYo.aqc()).auK();
                    }
                    TiebaStatic.log(new al("c11749").ac(ImageViewerConfig.FORUM_ID, h.this.dof.getFid()).ac("obj_locate", "1"));
                }
            }
        };
        this.cYA = frsFragment.apf();
        frsFragment.registerListener(this.drK);
    }

    public void c(com.baidu.tieba.frs.i iVar, boolean z) {
        if (iVar != null) {
            iVar.fA(z);
            iVar.a(this.anZ);
            iVar.a(this.aob);
            iVar.a(this.aoa);
        }
    }
}
