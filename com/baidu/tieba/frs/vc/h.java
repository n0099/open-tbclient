package com.baidu.tieba.frs.vc;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes4.dex */
public class h extends com.baidu.tieba.frs.mc.j {
    private h.c bZB;
    private h.b bZC;
    private h.d bZD;
    private boolean fMD;
    private final CustomMessageListener fME;
    private com.baidu.tieba.frs.smartsort.a fpl;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fMD = false;
        this.fME = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.foQ != null) {
                    h.this.foQ.startPullRefresh();
                }
            }
        };
        this.bZB = new h.c() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (h.this.fHd != null && h.this.fHd.isAdded() && h.this.foQ != null) {
                    h.this.foQ.fY(true);
                    if (com.baidu.adp.lib.util.j.jS()) {
                        h.this.fHd.refresh();
                        h.this.fHd.jF(true);
                    } else {
                        h.this.fHd.bjS();
                    }
                    TiebaStatic.log(new am("c11749").bT("fid", h.this.fHd.getFid()).bT("obj_locate", "1"));
                }
            }
        };
        this.bZD = new h.d() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.h.d
            public void eo(boolean z) {
                h.this.fMD = true;
                if (h.this.foQ != null && h.this.fIn != null && h.this.fpi != null && h.this.fHd != null && h.this.fHd.isAdded()) {
                    if (h.this.foQ != null && h.this.foQ.bkH() != null) {
                        h.this.foQ.bkH().bvS();
                    }
                    h.this.fHd.jF(false);
                    com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.foQ.bkx() != null && h.this.fIn != null && h.this.foQ.bkx().getVisibility() != 0) {
                                h.this.fIn.avk();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.bZC = new h.b() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (h.this.fHd != null && h.this.fHd.isAdded()) {
                    if (h.this.fMD && h.this.fHd.bjN() != null) {
                        h.this.fHd.bjN().bqQ();
                        h.this.fMD = false;
                    }
                    if (h.this.fpl != null && h.this.fHd.bjP() != null && h.this.fHd.bjP().bkJ() != null && !h.this.fHd.bjP().bkJ().bqq()) {
                        h.this.fpl.bpA();
                    }
                    if (h.this.foQ != null && h.this.fIn != null && h.this.fpi != null && h.this.fpl != null) {
                        h.this.foQ.bkH().c(0, 0, true, true);
                        h.this.fHd.bjZ();
                        h.this.fHd.jF(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.fHd.bjP() != null) {
                            h.this.fHd.bjP().fY(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.fHd.ajY().getVisibility() != 0 || v.aa(h.this.fHd.bkm().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.fpl = frsFragment.bjJ();
        frsFragment.registerListener(this.fME);
    }

    public void bqI() {
        if (this.foQ != null) {
            this.foQ.setListPullRefreshListener(this.bZB);
            this.foQ.a(this.bZD);
            this.foQ.a(this.bZC);
        }
    }
}
