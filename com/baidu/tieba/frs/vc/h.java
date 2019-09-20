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
    private h.c cbC;
    private h.b cbD;
    private h.d cbE;
    private boolean fUf;
    private final CustomMessageListener fUg;
    private com.baidu.tieba.frs.smartsort.a fww;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fUf = false;
        this.fUg = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.fwb != null) {
                    h.this.fwb.startPullRefresh();
                }
            }
        };
        this.cbC = new h.c() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                if (h.this.fOE != null && h.this.fOE.isAdded() && h.this.fwb != null) {
                    h.this.fwb.gf(true);
                    if (com.baidu.adp.lib.util.j.kc()) {
                        h.this.fOE.refresh();
                        h.this.fOE.jS(true);
                    } else {
                        h.this.fOE.bmM();
                    }
                    TiebaStatic.log(new an("c11749").bT("fid", h.this.fOE.getFid()).bT("obj_locate", "1"));
                }
            }
        };
        this.cbE = new h.d() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.h.d
            public void ev(boolean z) {
                h.this.fUf = true;
                if (h.this.fwb != null && h.this.fPP != null && h.this.fwt != null && h.this.fOE != null && h.this.fOE.isAdded()) {
                    if (h.this.fwb != null && h.this.fwb.bnE() != null) {
                        h.this.fwb.bnE().bxn();
                    }
                    h.this.fOE.jS(false);
                    com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.fwb.bnu() != null && h.this.fPP != null && h.this.fwb.bnu().getVisibility() != 0) {
                                h.this.fPP.awH();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.cbD = new h.b() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (h.this.fOE != null && h.this.fOE.isAdded()) {
                    if (h.this.fUf && h.this.fOE.bmH() != null) {
                        h.this.fOE.bmH().btS();
                        h.this.fUf = false;
                    }
                    if (h.this.fww != null && h.this.fOE.bmJ() != null && h.this.fOE.bmJ().bnG() != null && !h.this.fOE.bmJ().bnG().btr()) {
                        h.this.fww.bsB();
                    }
                    if (h.this.fwb != null && h.this.fPP != null && h.this.fwt != null && h.this.fww != null) {
                        h.this.fwb.bnE().c(0, 0, true, true);
                        h.this.fOE.bmW();
                        h.this.fOE.jS(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.fOE.bmJ() != null) {
                            h.this.fOE.bmJ().gf(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.fOE.alr().getVisibility() != 0 || v.aa(h.this.fOE.bnj().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.fww = frsFragment.bmD();
        frsFragment.registerListener(this.fUg);
    }

    public void btJ() {
        if (this.fwb != null) {
            this.fwb.setListPullRefreshListener(this.cbC);
            this.fwb.a(this.cbE);
            this.fwb.a(this.cbD);
        }
    }
}
