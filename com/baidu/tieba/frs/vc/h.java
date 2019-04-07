package com.baidu.tieba.frs.vc;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes4.dex */
public class h extends com.baidu.tieba.frs.mc.j {
    private h.c bRI;
    private h.b bRJ;
    private h.d bRK;
    private com.baidu.tieba.frs.smartsort.b eYZ;
    private boolean fvK;
    private final CustomMessageListener fvL;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fvK = false;
        this.fvL = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.eYE != null) {
                    h.this.eYE.startPullRefresh();
                }
            }
        };
        this.bRI = new h.c() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (h.this.fqE != null && h.this.fqE.isAdded() && h.this.eYE != null) {
                    h.this.eYE.fB(true);
                    if (com.baidu.adp.lib.util.j.kY()) {
                        h.this.fqE.refresh();
                        h.this.fqE.iV(true);
                    } else {
                        h.this.fqE.bcv();
                    }
                    TiebaStatic.log(new am("c11749").bJ(ImageViewerConfig.FORUM_ID, h.this.fqE.getFid()).bJ("obj_locate", "1"));
                }
            }
        };
        this.bRK = new h.d() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.h.d
            public void dS(boolean z) {
                h.this.fvK = true;
                if (h.this.eYE != null && h.this.frP != null && h.this.eYW != null && h.this.fqE != null && h.this.fqE.isAdded()) {
                    if (h.this.eYE != null && h.this.eYE.bdm() != null) {
                        h.this.eYE.bdm().bol();
                    }
                    h.this.fqE.iV(false);
                    com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.eYE.bdc() != null && h.this.frP != null && h.this.eYE.bdc().getVisibility() != 0) {
                                h.this.frP.aqf();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.bRJ = new h.b() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (h.this.fqE != null && h.this.fqE.isAdded()) {
                    if (h.this.fvK && h.this.fqE.bcq() != null) {
                        h.this.fqE.bcq().bjt();
                        h.this.fvK = false;
                    }
                    if (h.this.eYZ != null && h.this.fqE.bcs() != null && h.this.fqE.bcs().bdo() != null && !h.this.fqE.bcs().bdo().biT()) {
                        h.this.eYZ.bih();
                    }
                    if (h.this.eYE != null && h.this.frP != null && h.this.eYW != null && h.this.eYZ != null) {
                        h.this.eYE.bdm().c(0, 0, true, true);
                        h.this.fqE.bcC();
                        h.this.fqE.iV(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.fqE.bcs() != null) {
                            h.this.fqE.bcs().fB(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.fqE.aeZ().getVisibility() != 0 || v.T(h.this.fqE.bcP().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.eYZ = frsFragment.bcm();
        frsFragment.registerListener(this.fvL);
    }

    public void bjl() {
        if (this.eYE != null) {
            this.eYE.setListPullRefreshListener(this.bRI);
            this.eYE.a(this.bRK);
            this.eYE.a(this.bRJ);
        }
    }
}
