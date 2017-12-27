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
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.card.s;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.view.a;
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.frs.mc.h {
    private i.b baS;
    private i.a baT;
    private i.c baU;
    private final CustomMessageListener dNx;
    private final a.InterfaceC0167a dNy;
    private com.baidu.tieba.frs.smartsort.b dwT;

    public h(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dNx = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.f.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.dwH != null) {
                    h.this.dwH.startPullRefresh();
                }
            }
        };
        this.baS = new i.b() { // from class: com.baidu.tieba.frs.f.h.2
            @Override // com.baidu.tbadk.core.view.i.b
            public void onListPullRefresh(boolean z) {
                if (h.this.dKN != null && h.this.dKN.isAdded()) {
                    h.this.dwH.cN(true);
                    if (com.baidu.adp.lib.util.j.oI()) {
                        h.this.dKN.refresh();
                        if (h.this.dwH != null) {
                            h.this.dKN.fx(true);
                        } else {
                            return;
                        }
                    } else {
                        h.this.dKN.asY();
                    }
                    TiebaStatic.log(new ak("c11749").ab(ImageViewerConfig.FORUM_ID, h.this.dKN.getFid()).ab("obj_locate", "1"));
                }
            }
        };
        this.baU = new i.c() { // from class: com.baidu.tieba.frs.f.h.3
            @Override // com.baidu.tbadk.core.view.i.c
            public void br(boolean z) {
                if (h.this.dwH != null && h.this.dLI != null && h.this.dwQ != null && h.this.dKN != null && h.this.dKN.isAdded()) {
                    if (h.this.dwH != null && h.this.dwH.atw() != null) {
                        h.this.dwH.atw().aCw();
                    }
                    h.this.dKN.fx(false);
                    com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.f.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.dwH.att() != null && h.this.dLI != null && h.this.dwH.att().getVisibility() != 0) {
                                h.this.dLI.ON();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.baT = new i.a() { // from class: com.baidu.tieba.frs.f.h.4
            @Override // com.baidu.tbadk.core.view.i.a
            public void i(View view, boolean z) {
                if (h.this.dKN != null && h.this.dKN.isAdded()) {
                    if (h.this.dwT != null && h.this.dKN.asV() != null && h.this.dKN.asV().aty() != null && !h.this.dKN.asV().aty().avx()) {
                        h.this.dwT.axB();
                    }
                    if (h.this.dwH != null && h.this.dLI != null && h.this.dwQ != null && h.this.dwT != null) {
                        h.this.dKN.atc();
                        h.this.dKN.fx(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.dKN.asV() != null) {
                            h.this.dKN.asV().cN(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.dKN.El().getVisibility() != 0 || v.G(h.this.dKN.atn().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.dNy = new a.InterfaceC0167a() { // from class: com.baidu.tieba.frs.f.h.5
            @Override // com.baidu.tieba.view.a.InterfaceC0167a
            public void L(float f) {
                if (h.this.dwH != null && (h.this.dwH.atx() instanceof com.baidu.tieba.frs.tab.a)) {
                    ((com.baidu.tieba.frs.tab.a) h.this.dwH.atx()).K(f);
                }
            }

            @Override // com.baidu.tieba.view.a.InterfaceC0167a
            public void st() {
                if (h.this.dwH != null && (h.this.dwH.atx() instanceof com.baidu.tieba.frs.tab.a)) {
                    ((com.baidu.tieba.frs.tab.a) h.this.dwH.atx()).axJ();
                }
            }

            @Override // com.baidu.tieba.view.a.InterfaceC0167a
            public void onRefresh() {
                if (h.this.dwH != null && h.this.dwH.atw() != null) {
                    h.this.dwH.atw().aCw();
                }
                s.ajC().eB(false);
                l atn = h.this.dKN.atn();
                if (h.this.dwH != null && atn != null && h.this.dwP != null) {
                    if (com.baidu.adp.lib.util.j.oI()) {
                        if (h.this.dwH.atx() instanceof com.baidu.tieba.frs.tab.a) {
                            if (!atn.bBr()) {
                                ((com.baidu.tieba.frs.tab.a) h.this.dwH.atx()).ss();
                            }
                            h.this.dwH.cN(true);
                        }
                        TiebaStatic.eventStat(h.this.dKN.getPageContext().getPageActivity(), "frs_pulldown", "frsclick", 1, new Object[0]);
                        if (atn.aYy() != null && atn.hgc == 1) {
                            com.baidu.tieba.frs.d.b.a(atn, h.this.dwP.axn(), 1);
                        }
                        h.this.dKN.refresh();
                    } else if (h.this.dwH.atx() instanceof com.baidu.tieba.frs.tab.a) {
                        ((com.baidu.tieba.frs.tab.a) h.this.dwH.atx()).axJ();
                    }
                    TiebaStatic.log(new ak("c11749").ab(ImageViewerConfig.FORUM_ID, h.this.dKN.getFid()).ab("obj_locate", "1"));
                }
            }
        };
        this.dwT = iVar.asP();
        iVar.registerListener(this.dNx);
    }

    public void a(com.baidu.tieba.frs.k kVar, boolean z) {
        if (kVar != null) {
            kVar.fG(z);
            kVar.a(this.baS);
            kVar.a(this.baU);
            kVar.a(this.baT);
        }
    }
}
