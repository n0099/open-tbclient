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
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes4.dex */
public class h extends com.baidu.tieba.frs.mc.j {
    private h.c cpS;
    private h.b cpT;
    private h.d cpU;
    private final CustomMessageListener fTA;
    private boolean fTz;
    private com.baidu.tieba.frs.smartsort.a fvJ;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fTz = false;
        this.fTA = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.fvo != null) {
                    h.this.fvo.startPullRefresh();
                }
            }
        };
        this.cpS = new h.c() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (h.this.fNY != null && h.this.fNY.isAdded() && h.this.fvo != null) {
                    h.this.fvo.fU(true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        h.this.fNY.refresh();
                        h.this.fNY.jG(true);
                    } else {
                        h.this.fNY.bjS();
                    }
                    TiebaStatic.log(new an("c11749").bS("fid", h.this.fNY.getFid()).bS("obj_locate", "1"));
                }
            }
        };
        this.cpU = new h.d() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.h.d
            public void onListPullToRefresh(boolean z) {
                h.this.fTz = true;
                if (h.this.fvo != null && h.this.fPj != null && h.this.fvG != null && h.this.fNY != null && h.this.fNY.isAdded()) {
                    if (h.this.fvo != null && h.this.fvo.bkJ() != null) {
                        h.this.fvo.bkJ().bur();
                    }
                    h.this.fNY.jG(false);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.fvo.bkA() != null && h.this.fPj != null && h.this.fvo.bkA().getVisibility() != 0) {
                                h.this.fPj.axK();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.cpT = new h.b() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (h.this.fNY != null && h.this.fNY.isAdded()) {
                    if (h.this.fTz && h.this.fNY.bjN() != null) {
                        h.this.fNY.bjN().bqV();
                        h.this.fTz = false;
                    }
                    if (h.this.fvJ != null && h.this.fNY.bjP() != null && h.this.fNY.bjP().bkL() != null && !h.this.fNY.bjP().bkL().bqu()) {
                        h.this.fvJ.bpF();
                    }
                    if (h.this.fvo != null && h.this.fPj != null && h.this.fvG != null && h.this.fvJ != null) {
                        h.this.fvo.bkJ().c(0, 0, true, true);
                        h.this.fNY.bkc();
                        h.this.fNY.jG(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.fNY.bjP() != null) {
                            h.this.fNY.bjP().fU(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.fNY.aof().getVisibility() != 0 || v.isEmpty(h.this.fNY.bkp().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.fvJ = frsFragment.bjJ();
        frsFragment.registerListener(this.fTA);
    }

    public void bqM() {
        if (this.fvo != null) {
            this.fvo.setListPullRefreshListener(this.cpS);
            this.fvo.a(this.cpU);
            this.fvo.a(this.cpT);
        }
    }
}
