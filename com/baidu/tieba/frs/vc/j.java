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
    private g.c dgH;
    private g.b dgI;
    private g.d dgJ;
    private boolean gMv;
    private final CustomMessageListener gMw;
    private com.baidu.tieba.frs.smartsort.a goE;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.gMv = false;
        this.gMw = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.gok != null) {
                    j.this.gok.startPullRefresh();
                }
            }
        };
        this.dgH = new g.c() { // from class: com.baidu.tieba.frs.vc.j.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (j.this.gGD != null && j.this.gGD.isAdded() && j.this.gok != null) {
                    j.this.gok.hu(true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.gGD.refresh();
                        j.this.gGD.lh(true);
                    } else {
                        j.this.gGD.bDQ();
                    }
                    TiebaStatic.log(new an("c11749").cy("fid", j.this.gGD.getFid()).cy("obj_locate", "1"));
                }
            }
        };
        this.dgJ = new g.d() { // from class: com.baidu.tieba.frs.vc.j.3
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                j.this.gMv = true;
                if (j.this.gok != null && j.this.gHT != null && j.this.goB != null && j.this.gGD != null && j.this.gGD.isAdded()) {
                    if (j.this.gok != null && j.this.gok.bEI() != null) {
                        j.this.gok.bEI().bOn();
                    }
                    j.this.gGD.lh(false);
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.gok.bEz() != null && j.this.gHT != null && j.this.gok.bEz().getVisibility() != 0) {
                                j.this.gHT.aSk();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.dgI = new g.b() { // from class: com.baidu.tieba.frs.vc.j.4
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (j.this.gGD != null && j.this.gGD.isAdded()) {
                    if (j.this.gMv && j.this.gGD.bDL() != null) {
                        j.this.gGD.bDL().bKX();
                        j.this.gMv = false;
                    }
                    if (j.this.goE != null && j.this.gGD.bDN() != null && j.this.gGD.bDN().bEK() != null && !j.this.gGD.bDN().bEK().bKs()) {
                        j.this.goE.bJD();
                    }
                    if (j.this.gok != null && j.this.gHT != null && j.this.goB != null && j.this.goE != null) {
                        j.this.gok.bEI().a(0, 0, true, true);
                        j.this.gGD.bEa();
                        j.this.gGD.lh(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.gGD.bDN() != null) {
                            j.this.gGD.bDN().hu(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.gGD.aIf().getVisibility() != 0 || v.isEmpty(j.this.gGD.bEn().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.goE = frsFragment.bDH();
        frsFragment.registerListener(this.gMw);
    }

    public void bKO() {
        if (this.gok != null) {
            this.gok.setListPullRefreshListener(this.dgH);
            this.gok.a(this.dgJ);
            this.gok.a(this.dgI);
        }
    }
}
