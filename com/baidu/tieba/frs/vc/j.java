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
    private g.c dgI;
    private g.b dgJ;
    private g.d dgK;
    private boolean gMx;
    private final CustomMessageListener gMy;
    private com.baidu.tieba.frs.smartsort.a goG;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.gMx = false;
        this.gMy = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.gom != null) {
                    j.this.gom.startPullRefresh();
                }
            }
        };
        this.dgI = new g.c() { // from class: com.baidu.tieba.frs.vc.j.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (j.this.gGF != null && j.this.gGF.isAdded() && j.this.gom != null) {
                    j.this.gom.hu(true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.gGF.refresh();
                        j.this.gGF.lh(true);
                    } else {
                        j.this.gGF.bDS();
                    }
                    TiebaStatic.log(new an("c11749").cy("fid", j.this.gGF.getFid()).cy("obj_locate", "1"));
                }
            }
        };
        this.dgK = new g.d() { // from class: com.baidu.tieba.frs.vc.j.3
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                j.this.gMx = true;
                if (j.this.gom != null && j.this.gHV != null && j.this.goD != null && j.this.gGF != null && j.this.gGF.isAdded()) {
                    if (j.this.gom != null && j.this.gom.bEK() != null) {
                        j.this.gom.bEK().bOp();
                    }
                    j.this.gGF.lh(false);
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.gom.bEB() != null && j.this.gHV != null && j.this.gom.bEB().getVisibility() != 0) {
                                j.this.gHV.aSm();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.dgJ = new g.b() { // from class: com.baidu.tieba.frs.vc.j.4
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (j.this.gGF != null && j.this.gGF.isAdded()) {
                    if (j.this.gMx && j.this.gGF.bDN() != null) {
                        j.this.gGF.bDN().bKZ();
                        j.this.gMx = false;
                    }
                    if (j.this.goG != null && j.this.gGF.bDP() != null && j.this.gGF.bDP().bEM() != null && !j.this.gGF.bDP().bEM().bKu()) {
                        j.this.goG.bJF();
                    }
                    if (j.this.gom != null && j.this.gHV != null && j.this.goD != null && j.this.goG != null) {
                        j.this.gom.bEK().a(0, 0, true, true);
                        j.this.gGF.bEc();
                        j.this.gGF.lh(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.gGF.bDP() != null) {
                            j.this.gGF.bDP().hu(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.gGF.aIh().getVisibility() != 0 || v.isEmpty(j.this.gGF.bEp().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.goG = frsFragment.bDJ();
        frsFragment.registerListener(this.gMy);
    }

    public void bKQ() {
        if (this.gom != null) {
            this.gom.setListPullRefreshListener(this.dgI);
            this.gom.a(this.dgK);
            this.gom.a(this.dgJ);
        }
    }
}
