package com.baidu.tieba.frs.vc;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes4.dex */
public class h extends com.baidu.tieba.frs.mc.j {
    private h.c caD;
    private h.b caE;
    private h.d caF;
    private boolean fRA;
    private final CustomMessageListener fRB;
    private com.baidu.tieba.frs.smartsort.a fuk;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fRA = false;
        this.fRB = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.ftP != null) {
                    h.this.ftP.startPullRefresh();
                }
            }
        };
        this.caD = new h.c() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (h.this.fMb != null && h.this.fMb.isAdded() && h.this.ftP != null) {
                    h.this.ftP.gc(true);
                    if (com.baidu.adp.lib.util.j.kc()) {
                        h.this.fMb.refresh();
                        h.this.fMb.jP(true);
                    } else {
                        h.this.fMb.blU();
                    }
                    TiebaStatic.log(new an("c11749").bT("fid", h.this.fMb.getFid()).bT("obj_locate", "1"));
                }
            }
        };
        this.caF = new h.d() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.h.d
            public void es(boolean z) {
                h.this.fRA = true;
                if (h.this.ftP != null && h.this.fNl != null && h.this.fuh != null && h.this.fMb != null && h.this.fMb.isAdded()) {
                    if (h.this.ftP != null && h.this.ftP.bmJ() != null) {
                        h.this.ftP.bmJ().bwl();
                    }
                    h.this.fMb.jP(false);
                    com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.ftP.bmz() != null && h.this.fNl != null && h.this.ftP.bmz().getVisibility() != 0) {
                                h.this.fNl.awt();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.caE = new h.b() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (h.this.fMb != null && h.this.fMb.isAdded()) {
                    if (h.this.fRA && h.this.fMb.blP() != null) {
                        h.this.fMb.blP().bsR();
                        h.this.fRA = false;
                    }
                    if (h.this.fuk != null && h.this.fMb.blR() != null && h.this.fMb.blR().bmL() != null && !h.this.fMb.blR().bmL().bsr()) {
                        h.this.fuk.brB();
                    }
                    if (h.this.ftP != null && h.this.fNl != null && h.this.fuh != null && h.this.fuk != null) {
                        h.this.ftP.bmJ().c(0, 0, true, true);
                        h.this.fMb.bmb();
                        h.this.fMb.jP(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.fMb.blR() != null) {
                            h.this.fMb.blR().gc(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.fMb.ald().getVisibility() != 0 || v.aa(h.this.fMb.bmo().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.fuk = frsFragment.blL();
        frsFragment.registerListener(this.fRB);
    }

    public void bsJ() {
        if (this.ftP != null) {
            this.ftP.setListPullRefreshListener(this.caD);
            this.ftP.a(this.caF);
            this.ftP.a(this.caE);
        }
    }
}
