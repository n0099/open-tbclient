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
/* loaded from: classes7.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private g.c dcC;
    private g.b dcD;
    private g.d dcE;
    private boolean gKw;
    private final CustomMessageListener gKx;
    private com.baidu.tieba.frs.smartsort.a gmD;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.gKw = false;
        this.gKx = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.gmj != null) {
                    j.this.gmj.startPullRefresh();
                }
            }
        };
        this.dcC = new g.c() { // from class: com.baidu.tieba.frs.vc.j.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (j.this.gEE != null && j.this.gEE.isAdded() && j.this.gmj != null) {
                    j.this.gmj.hn(true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.gEE.refresh();
                        j.this.gEE.ld(true);
                    } else {
                        j.this.gEE.bCn();
                    }
                    TiebaStatic.log(new an("c11749").cp("fid", j.this.gEE.getFid()).cp("obj_locate", "1"));
                }
            }
        };
        this.dcE = new g.d() { // from class: com.baidu.tieba.frs.vc.j.3
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                j.this.gKw = true;
                if (j.this.gmj != null && j.this.gFU != null && j.this.gmA != null && j.this.gEE != null && j.this.gEE.isAdded()) {
                    if (j.this.gmj != null && j.this.gmj.bDf() != null) {
                        j.this.gmj.bDf().bML();
                    }
                    j.this.gEE.ld(false);
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.gmj.bCW() != null && j.this.gFU != null && j.this.gmj.bCW().getVisibility() != 0) {
                                j.this.gFU.aPT();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.dcD = new g.b() { // from class: com.baidu.tieba.frs.vc.j.4
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (j.this.gEE != null && j.this.gEE.isAdded()) {
                    if (j.this.gKw && j.this.gEE.bCi() != null) {
                        j.this.gEE.bCi().bJw();
                        j.this.gKw = false;
                    }
                    if (j.this.gmD != null && j.this.gEE.bCk() != null && j.this.gEE.bCk().bDh() != null && !j.this.gEE.bCk().bDh().bIQ()) {
                        j.this.gmD.bIb();
                    }
                    if (j.this.gmj != null && j.this.gFU != null && j.this.gmA != null && j.this.gmD != null) {
                        j.this.gmj.bDf().a(0, 0, true, true);
                        j.this.gEE.bCx();
                        j.this.gEE.ld(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.gEE.bCk() != null) {
                            j.this.gEE.bCk().hn(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.gEE.aFQ().getVisibility() != 0 || v.isEmpty(j.this.gEE.bCK().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.gmD = frsFragment.bCe();
        frsFragment.registerListener(this.gKx);
    }

    public void bJn() {
        if (this.gmj != null) {
            this.gmj.setListPullRefreshListener(this.dcC);
            this.gmj.a(this.dcE);
            this.gmj.a(this.dcD);
        }
    }
}
