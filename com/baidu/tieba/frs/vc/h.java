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
    private h.c bRG;
    private h.b bRH;
    private h.d bRI;
    private com.baidu.tieba.frs.smartsort.b eZn;
    private boolean fvY;
    private final CustomMessageListener fvZ;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fvY = false;
        this.fvZ = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.eYS != null) {
                    h.this.eYS.startPullRefresh();
                }
            }
        };
        this.bRG = new h.c() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (h.this.fqS != null && h.this.fqS.isAdded() && h.this.eYS != null) {
                    h.this.eYS.fB(true);
                    if (com.baidu.adp.lib.util.j.kY()) {
                        h.this.fqS.refresh();
                        h.this.fqS.iV(true);
                    } else {
                        h.this.fqS.bcx();
                    }
                    TiebaStatic.log(new am("c11749").bJ(ImageViewerConfig.FORUM_ID, h.this.fqS.getFid()).bJ("obj_locate", "1"));
                }
            }
        };
        this.bRI = new h.d() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.h.d
            public void dS(boolean z) {
                h.this.fvY = true;
                if (h.this.eYS != null && h.this.fsd != null && h.this.eZk != null && h.this.fqS != null && h.this.fqS.isAdded()) {
                    if (h.this.eYS != null && h.this.eYS.bdo() != null) {
                        h.this.eYS.bdo().boo();
                    }
                    h.this.fqS.iV(false);
                    com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.eYS.bde() != null && h.this.fsd != null && h.this.eYS.bde().getVisibility() != 0) {
                                h.this.fsd.aqi();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.bRH = new h.b() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (h.this.fqS != null && h.this.fqS.isAdded()) {
                    if (h.this.fvY && h.this.fqS.bcs() != null) {
                        h.this.fqS.bcs().bjv();
                        h.this.fvY = false;
                    }
                    if (h.this.eZn != null && h.this.fqS.bcu() != null && h.this.fqS.bcu().bdq() != null && !h.this.fqS.bcu().bdq().biV()) {
                        h.this.eZn.bij();
                    }
                    if (h.this.eYS != null && h.this.fsd != null && h.this.eZk != null && h.this.eZn != null) {
                        h.this.eYS.bdo().c(0, 0, true, true);
                        h.this.fqS.bcE();
                        h.this.fqS.iV(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.fqS.bcu() != null) {
                            h.this.fqS.bcu().fB(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.fqS.afc().getVisibility() != 0 || v.T(h.this.fqS.bcR().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.eZn = frsFragment.bco();
        frsFragment.registerListener(this.fvZ);
    }

    public void bjn() {
        if (this.eYS != null) {
            this.eYS.setListPullRefreshListener(this.bRG);
            this.eYS.a(this.bRI);
            this.eYS.a(this.bRH);
        }
    }
}
