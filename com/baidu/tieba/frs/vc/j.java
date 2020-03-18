package com.baidu.tieba.frs.vc;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes9.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private g.c dhi;
    private g.b dhj;
    private g.d dhk;
    private boolean gNO;
    private final CustomMessageListener gNP;
    private com.baidu.tieba.frs.smartsort.a gpD;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.gNO = false;
        this.gNP = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.gpj != null) {
                    j.this.gpj.startPullRefresh();
                }
            }
        };
        this.dhi = new g.c() { // from class: com.baidu.tieba.frs.vc.j.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (j.this.gHP != null && j.this.gHP.isAdded() && j.this.gpj != null) {
                    j.this.gpj.hv(true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.gHP.refresh();
                        j.this.gHP.ln(true);
                    } else {
                        j.this.gHP.bEb();
                    }
                    TiebaStatic.log(new an("c11749").cx("fid", j.this.gHP.getFid()).cx("obj_locate", "1"));
                }
            }
        };
        this.dhk = new g.d() { // from class: com.baidu.tieba.frs.vc.j.3
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                j.this.gNO = true;
                if (j.this.gpj != null && j.this.gJg != null && j.this.gpA != null && j.this.gHP != null && j.this.gHP.isAdded()) {
                    if (j.this.gpj != null && j.this.gpj.bEV() != null) {
                        j.this.gpj.bEV().bOE();
                    }
                    j.this.gHP.ln(false);
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.gpj.bEM() != null && j.this.gJg != null && j.this.gpj.bEM().getVisibility() != 0) {
                                j.this.gJg.aSr();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.dhj = new g.b() { // from class: com.baidu.tieba.frs.vc.j.4
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (j.this.gHP != null && j.this.gHP.isAdded()) {
                    if (j.this.gNO && j.this.gHP.bDW() != null) {
                        j.this.gHP.bDW().bLo();
                        j.this.gNO = false;
                    }
                    if (j.this.gpD != null && j.this.gHP.bDY() != null && j.this.gHP.bDY().bEX() != null && !j.this.gHP.bDY().bEX().bKI()) {
                        j.this.gpD.bJT();
                    }
                    if (j.this.gpj != null && j.this.gJg != null && j.this.gpA != null && j.this.gpD != null) {
                        j.this.gpj.bEV().a(0, 0, true, true);
                        j.this.gHP.bEm();
                        j.this.gHP.ln(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.gHP.bDY() != null) {
                            j.this.gHP.bDY().hv(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.gHP.aIm().getVisibility() != 0 || v.isEmpty(j.this.gHP.bEz().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.gpD = frsFragment.bDS();
        frsFragment.registerListener(this.gNP);
    }

    public void bLe() {
        if (this.gpj != null) {
            this.gpj.setListPullRefreshListener(this.dhi);
            this.gpj.a(this.dhk);
            this.gpj.a(this.dhj);
        }
    }
}
