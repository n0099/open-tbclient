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
    private h.c bZA;
    private h.b bZB;
    private h.d bZC;
    private boolean fMA;
    private final CustomMessageListener fMB;
    private com.baidu.tieba.frs.smartsort.a fpk;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fMA = false;
        this.fMB = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.foP != null) {
                    h.this.foP.startPullRefresh();
                }
            }
        };
        this.bZA = new h.c() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (h.this.fGZ != null && h.this.fGZ.isAdded() && h.this.foP != null) {
                    h.this.foP.fY(true);
                    if (com.baidu.adp.lib.util.j.jS()) {
                        h.this.fGZ.refresh();
                        h.this.fGZ.jF(true);
                    } else {
                        h.this.fGZ.bjP();
                    }
                    TiebaStatic.log(new am("c11749").bT("fid", h.this.fGZ.getFid()).bT("obj_locate", "1"));
                }
            }
        };
        this.bZC = new h.d() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.h.d
            public void eo(boolean z) {
                h.this.fMA = true;
                if (h.this.foP != null && h.this.fIk != null && h.this.fph != null && h.this.fGZ != null && h.this.fGZ.isAdded()) {
                    if (h.this.foP != null && h.this.foP.bkE() != null) {
                        h.this.foP.bkE().bvO();
                    }
                    h.this.fGZ.jF(false);
                    com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.foP.bku() != null && h.this.fIk != null && h.this.foP.bku().getVisibility() != 0) {
                                h.this.fIk.avk();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.bZB = new h.b() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (h.this.fGZ != null && h.this.fGZ.isAdded()) {
                    if (h.this.fMA && h.this.fGZ.bjK() != null) {
                        h.this.fGZ.bjK().bqL();
                        h.this.fMA = false;
                    }
                    if (h.this.fpk != null && h.this.fGZ.bjM() != null && h.this.fGZ.bjM().bkG() != null && !h.this.fGZ.bjM().bkG().bql()) {
                        h.this.fpk.bpv();
                    }
                    if (h.this.foP != null && h.this.fIk != null && h.this.fph != null && h.this.fpk != null) {
                        h.this.foP.bkE().c(0, 0, true, true);
                        h.this.fGZ.bjW();
                        h.this.fGZ.jF(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.fGZ.bjM() != null) {
                            h.this.fGZ.bjM().fY(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.fGZ.ajY().getVisibility() != 0 || v.aa(h.this.fGZ.bkj().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.fpk = frsFragment.bjG();
        frsFragment.registerListener(this.fMB);
    }

    public void bqD() {
        if (this.foP != null) {
            this.foP.setListPullRefreshListener(this.bZA);
            this.foP.a(this.bZC);
            this.foP.a(this.bZB);
        }
    }
}
