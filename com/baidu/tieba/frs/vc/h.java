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
    private h.c caJ;
    private h.b caK;
    private h.d caL;
    private boolean fSo;
    private final CustomMessageListener fSp;
    private com.baidu.tieba.frs.smartsort.a fuJ;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fSo = false;
        this.fSp = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.fuo != null) {
                    h.this.fuo.startPullRefresh();
                }
            }
        };
        this.caJ = new h.c() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (h.this.fMP != null && h.this.fMP.isAdded() && h.this.fuo != null) {
                    h.this.fuo.gc(true);
                    if (com.baidu.adp.lib.util.j.kc()) {
                        h.this.fMP.refresh();
                        h.this.fMP.jP(true);
                    } else {
                        h.this.fMP.bmb();
                    }
                    TiebaStatic.log(new an("c11749").bT("fid", h.this.fMP.getFid()).bT("obj_locate", "1"));
                }
            }
        };
        this.caL = new h.d() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.h.d
            public void es(boolean z) {
                h.this.fSo = true;
                if (h.this.fuo != null && h.this.fNZ != null && h.this.fuG != null && h.this.fMP != null && h.this.fMP.isAdded()) {
                    if (h.this.fuo != null && h.this.fuo.bmT() != null) {
                        h.this.fuo.bmT().bwz();
                    }
                    h.this.fMP.jP(false);
                    com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.fuo.bmJ() != null && h.this.fNZ != null && h.this.fuo.bmJ().getVisibility() != 0) {
                                h.this.fNZ.awv();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.caK = new h.b() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (h.this.fMP != null && h.this.fMP.isAdded()) {
                    if (h.this.fSo && h.this.fMP.blW() != null) {
                        h.this.fMP.blW().bte();
                        h.this.fSo = false;
                    }
                    if (h.this.fuJ != null && h.this.fMP.blY() != null && h.this.fMP.blY().bmV() != null && !h.this.fMP.blY().bmV().bsE()) {
                        h.this.fuJ.brO();
                    }
                    if (h.this.fuo != null && h.this.fNZ != null && h.this.fuG != null && h.this.fuJ != null) {
                        h.this.fuo.bmT().c(0, 0, true, true);
                        h.this.fMP.bml();
                        h.this.fMP.jP(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.fMP.blY() != null) {
                            h.this.fMP.blY().gc(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.fMP.alf().getVisibility() != 0 || v.aa(h.this.fMP.bmy().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.fuJ = frsFragment.blS();
        frsFragment.registerListener(this.fSp);
    }

    public void bsW() {
        if (this.fuo != null) {
            this.fuo.setListPullRefreshListener(this.caJ);
            this.fuo.a(this.caL);
            this.fuo.a(this.caK);
        }
    }
}
