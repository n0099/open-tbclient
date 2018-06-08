package com.baidu.tieba.frs.vc;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.card.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private f.b awh;
    private f.a awi;
    private f.c awj;
    private boolean dAW;
    private final CustomMessageListener dAX;
    private final BdExpandListView.a dAY;
    private com.baidu.tieba.frs.smartsort.b dhR;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.dAW = false;
        this.dAX = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dhC != null) {
                    h.this.dhC.startPullRefresh();
                }
            }
        };
        this.awh = new f.b() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                if (h.this.dxw != null && h.this.dxw.isAdded()) {
                    h.this.dhC.cm(true);
                    if (com.baidu.adp.lib.util.j.jD()) {
                        h.this.dxw.refresh();
                        if (h.this.dhC != null) {
                            h.this.dxw.fu(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dxw.atu();
                    }
                    TiebaStatic.log(new am("c11749").ah(ImageViewerConfig.FORUM_ID, h.this.dxw.getFid()).ah("obj_locate", "1"));
                }
            }
        };
        this.awj = new f.c() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.f.c
            public void aT(boolean z) {
                h.this.dAW = true;
                if (h.this.dhC != null && h.this.dyt != null && h.this.dhO != null && h.this.dxw != null && h.this.dxw.isAdded()) {
                    if (h.this.dhC != null && h.this.dhC.aug() != null) {
                        h.this.dhC.aug().aDT();
                    }
                    h.this.dxw.fu(false);
                    com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dhC.atT() != null && h.this.dyt != null && h.this.dhC.atT().getVisibility() != 0) {
                                h.this.dyt.Le();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.awi = new f.a() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.f.a
            public void c(View view, boolean z) {
                if (h.this.dxw != null && h.this.dxw.isAdded()) {
                    if (h.this.dAW && h.this.dxw.atp() != null) {
                        h.this.dxw.atp().azC();
                        h.this.dAW = false;
                    }
                    if (h.this.dhR != null && h.this.dxw.atr() != null && h.this.dxw.atr().aui() != null && !h.this.dxw.atr().aui().awh()) {
                        h.this.dhR.ayO();
                    }
                    if (h.this.dhC != null && h.this.dyt != null && h.this.dhO != null && h.this.dhR != null) {
                        h.this.dxw.aty();
                        h.this.dxw.fu(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.dxw.atr() != null) {
                            h.this.dxw.atr().cm(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dxw.AJ().getVisibility() != 0 || w.z(h.this.dxw.atI().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dAY = new BdExpandListView.a() { // from class: com.baidu.tieba.frs.vc.h.5
            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void N(float f) {
                if (h.this.dhC != null && (h.this.dhC.auh() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dhC.auh()).M(f);
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void nm() {
                if (h.this.dhC != null && (h.this.dhC.auh() instanceof com.baidu.tieba.frs.tab.c)) {
                    ((com.baidu.tieba.frs.tab.c) h.this.dhC.auh()).ayU();
                }
            }

            @Override // com.baidu.tieba.view.BdExpandListView.a
            public void onRefresh() {
                if (h.this.dhC != null && h.this.dhC.aug() != null) {
                    h.this.dhC.aug().aDT();
                }
                v.ajh().ey(false);
                l atI = h.this.dxw.atI();
                if (h.this.dhC != null && atI != null && h.this.dhN != null) {
                    if (com.baidu.adp.lib.util.j.jD()) {
                        if (h.this.dhC.auh() instanceof com.baidu.tieba.frs.tab.c) {
                            if (!atI.bwj()) {
                                ((com.baidu.tieba.frs.tab.c) h.this.dhC.auh()).nl();
                            }
                            h.this.dhC.cm(true);
                        }
                        TiebaStatic.eventStat(h.this.dxw.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (atI.bam() != null && atI.gGr == 1) {
                            com.baidu.tieba.frs.e.b.a(atI, h.this.dhN.ayz(), 1);
                        }
                        h.this.dxw.refresh();
                    } else if (h.this.dhC.auh() instanceof com.baidu.tieba.frs.tab.c) {
                        ((com.baidu.tieba.frs.tab.c) h.this.dhC.auh()).ayU();
                    }
                    TiebaStatic.log(new am("c11749").ah(ImageViewerConfig.FORUM_ID, h.this.dxw.getFid()).ah("obj_locate", "1"));
                }
            }
        };
        this.dhR = frsFragment.atl();
        frsFragment.registerListener(this.dAX);
    }

    public void c(com.baidu.tieba.frs.i iVar, boolean z) {
        if (iVar != null) {
            iVar.fF(z);
            iVar.a(this.awh);
            iVar.a(this.awj);
            iVar.a(this.awi);
        }
    }
}
