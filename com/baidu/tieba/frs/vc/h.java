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
    private h.c bRF;
    private h.b bRG;
    private h.d bRH;
    private com.baidu.tieba.frs.smartsort.b eZo;
    private boolean fvZ;
    private final CustomMessageListener fwa;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fvZ = false;
        this.fwa = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.eYT != null) {
                    h.this.eYT.startPullRefresh();
                }
            }
        };
        this.bRF = new h.c() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (h.this.fqT != null && h.this.fqT.isAdded() && h.this.eYT != null) {
                    h.this.eYT.fB(true);
                    if (com.baidu.adp.lib.util.j.kY()) {
                        h.this.fqT.refresh();
                        h.this.fqT.iV(true);
                    } else {
                        h.this.fqT.bcx();
                    }
                    TiebaStatic.log(new am("c11749").bJ(ImageViewerConfig.FORUM_ID, h.this.fqT.getFid()).bJ("obj_locate", "1"));
                }
            }
        };
        this.bRH = new h.d() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.h.d
            public void dS(boolean z) {
                h.this.fvZ = true;
                if (h.this.eYT != null && h.this.fse != null && h.this.eZl != null && h.this.fqT != null && h.this.fqT.isAdded()) {
                    if (h.this.eYT != null && h.this.eYT.bdo() != null) {
                        h.this.eYT.bdo().boo();
                    }
                    h.this.fqT.iV(false);
                    com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.eYT.bde() != null && h.this.fse != null && h.this.eYT.bde().getVisibility() != 0) {
                                h.this.fse.aqi();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.bRG = new h.b() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.h.b
            public void f(View view, boolean z) {
                if (h.this.fqT != null && h.this.fqT.isAdded()) {
                    if (h.this.fvZ && h.this.fqT.bcs() != null) {
                        h.this.fqT.bcs().bjv();
                        h.this.fvZ = false;
                    }
                    if (h.this.eZo != null && h.this.fqT.bcu() != null && h.this.fqT.bcu().bdq() != null && !h.this.fqT.bcu().bdq().biV()) {
                        h.this.eZo.bij();
                    }
                    if (h.this.eYT != null && h.this.fse != null && h.this.eZl != null && h.this.eZo != null) {
                        h.this.eYT.bdo().c(0, 0, true, true);
                        h.this.fqT.bcE();
                        h.this.fqT.iV(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                        if (h.this.fqT.bcu() != null) {
                            h.this.fqT.bcu().fB(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.fqT.afc().getVisibility() != 0 || v.T(h.this.fqT.bcR().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.eZo = frsFragment.bco();
        frsFragment.registerListener(this.fwa);
    }

    public void bjn() {
        if (this.eYT != null) {
            this.eYT.setListPullRefreshListener(this.bRF);
            this.eYT.a(this.bRH);
            this.eYT.a(this.bRG);
        }
    }
}
