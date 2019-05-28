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
    private boolean fMB;
    private final CustomMessageListener fMC;
    private com.baidu.tieba.frs.smartsort.a fpl;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fMB = false;
        this.fMC = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.foQ != null) {
                    h.this.foQ.startPullRefresh();
                }
            }
        };
        this.bZA = new h.c() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (h.this.fHa != null && h.this.fHa.isAdded() && h.this.foQ != null) {
                    h.this.foQ.fY(true);
                    if (com.baidu.adp.lib.util.j.jS()) {
                        h.this.fHa.refresh();
                        h.this.fHa.jF(true);
                    } else {
                        h.this.fHa.bjS();
                    }
                    TiebaStatic.log(new am("c11749").bT("fid", h.this.fHa.getFid()).bT("obj_locate", "1"));
                }
            }
        };
        this.bZC = new h.d() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.h.d
            public void eo(boolean z) {
                h.this.fMB = true;
                if (h.this.foQ != null && h.this.fIl != null && h.this.fpi != null && h.this.fHa != null && h.this.fHa.isAdded()) {
                    if (h.this.foQ != null && h.this.foQ.bkH() != null) {
                        h.this.foQ.bkH().bvR();
                    }
                    h.this.fHa.jF(false);
                    com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.foQ.bkx() != null && h.this.fIl != null && h.this.foQ.bkx().getVisibility() != 0) {
                                h.this.fIl.avk();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.bZB = new h.b() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (h.this.fHa != null && h.this.fHa.isAdded()) {
                    if (h.this.fMB && h.this.fHa.bjN() != null) {
                        h.this.fHa.bjN().bqO();
                        h.this.fMB = false;
                    }
                    if (h.this.fpl != null && h.this.fHa.bjP() != null && h.this.fHa.bjP().bkJ() != null && !h.this.fHa.bjP().bkJ().bqo()) {
                        h.this.fpl.bpy();
                    }
                    if (h.this.foQ != null && h.this.fIl != null && h.this.fpi != null && h.this.fpl != null) {
                        h.this.foQ.bkH().c(0, 0, true, true);
                        h.this.fHa.bjZ();
                        h.this.fHa.jF(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.fHa.bjP() != null) {
                            h.this.fHa.bjP().fY(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.fHa.ajY().getVisibility() != 0 || v.aa(h.this.fHa.bkm().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.fpl = frsFragment.bjJ();
        frsFragment.registerListener(this.fMC);
    }

    public void bqG() {
        if (this.foQ != null) {
            this.foQ.setListPullRefreshListener(this.bZA);
            this.foQ.a(this.bZC);
            this.foQ.a(this.bZB);
        }
    }
}
