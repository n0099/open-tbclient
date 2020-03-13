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
    private g.c dgV;
    private g.b dgW;
    private g.d dgX;
    private boolean gMJ;
    private final CustomMessageListener gMK;
    private com.baidu.tieba.frs.smartsort.a goT;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.gMJ = false;
        this.gMK = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.goz != null) {
                    j.this.goz.startPullRefresh();
                }
            }
        };
        this.dgV = new g.c() { // from class: com.baidu.tieba.frs.vc.j.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (j.this.gGR != null && j.this.gGR.isAdded() && j.this.goz != null) {
                    j.this.goz.hu(true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.gGR.refresh();
                        j.this.gGR.lh(true);
                    } else {
                        j.this.gGR.bDT();
                    }
                    TiebaStatic.log(new an("c11749").cy("fid", j.this.gGR.getFid()).cy("obj_locate", "1"));
                }
            }
        };
        this.dgX = new g.d() { // from class: com.baidu.tieba.frs.vc.j.3
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                j.this.gMJ = true;
                if (j.this.goz != null && j.this.gIh != null && j.this.goQ != null && j.this.gGR != null && j.this.gGR.isAdded()) {
                    if (j.this.goz != null && j.this.goz.bEL() != null) {
                        j.this.goz.bEL().bOq();
                    }
                    j.this.gGR.lh(false);
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.goz.bEC() != null && j.this.gIh != null && j.this.goz.bEC().getVisibility() != 0) {
                                j.this.gIh.aSn();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.dgW = new g.b() { // from class: com.baidu.tieba.frs.vc.j.4
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (j.this.gGR != null && j.this.gGR.isAdded()) {
                    if (j.this.gMJ && j.this.gGR.bDO() != null) {
                        j.this.gGR.bDO().bLa();
                        j.this.gMJ = false;
                    }
                    if (j.this.goT != null && j.this.gGR.bDQ() != null && j.this.gGR.bDQ().bEN() != null && !j.this.gGR.bDQ().bEN().bKv()) {
                        j.this.goT.bJG();
                    }
                    if (j.this.goz != null && j.this.gIh != null && j.this.goQ != null && j.this.goT != null) {
                        j.this.goz.bEL().a(0, 0, true, true);
                        j.this.gGR.bEd();
                        j.this.gGR.lh(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.gGR.bDQ() != null) {
                            j.this.gGR.bDQ().hu(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.gGR.aIi().getVisibility() != 0 || v.isEmpty(j.this.gGR.bEq().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.goT = frsFragment.bDK();
        frsFragment.registerListener(this.gMK);
    }

    public void bKR() {
        if (this.goz != null) {
            this.goz.setListPullRefreshListener(this.dgV);
            this.goz.a(this.dgX);
            this.goz.a(this.dgW);
        }
    }
}
