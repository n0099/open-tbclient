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
    private h.c cpa;
    private h.b cpb;
    private h.d cpc;
    private boolean fSI;
    private final CustomMessageListener fSJ;
    private com.baidu.tieba.frs.smartsort.a fuS;

    public h(FrsFragment frsFragment) {
        super(frsFragment);
        this.fSI = false;
        this.fSJ = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && h.this.fux != null) {
                    h.this.fux.startPullRefresh();
                }
            }
        };
        this.cpa = new h.c() { // from class: com.baidu.tieba.frs.vc.h.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (h.this.fNh != null && h.this.fNh.isAdded() && h.this.fux != null) {
                    h.this.fux.fU(true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        h.this.fNh.refresh();
                        h.this.fNh.jG(true);
                    } else {
                        h.this.fNh.bjQ();
                    }
                    TiebaStatic.log(new an("c11749").bS("fid", h.this.fNh.getFid()).bS("obj_locate", "1"));
                }
            }
        };
        this.cpc = new h.d() { // from class: com.baidu.tieba.frs.vc.h.3
            @Override // com.baidu.tbadk.core.view.h.d
            public void onListPullToRefresh(boolean z) {
                h.this.fSI = true;
                if (h.this.fux != null && h.this.fOs != null && h.this.fuP != null && h.this.fNh != null && h.this.fNh.isAdded()) {
                    if (h.this.fux != null && h.this.fux.bkH() != null) {
                        h.this.fux.bkH().bup();
                    }
                    h.this.fNh.jG(false);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.fux.bky() != null && h.this.fOs != null && h.this.fux.bky().getVisibility() != 0) {
                                h.this.fOs.axI();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.cpb = new h.b() { // from class: com.baidu.tieba.frs.vc.h.4
            @Override // com.baidu.tbadk.core.view.h.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (h.this.fNh != null && h.this.fNh.isAdded()) {
                    if (h.this.fSI && h.this.fNh.bjL() != null) {
                        h.this.fNh.bjL().bqT();
                        h.this.fSI = false;
                    }
                    if (h.this.fuS != null && h.this.fNh.bjN() != null && h.this.fNh.bjN().bkJ() != null && !h.this.fNh.bjN().bkJ().bqs()) {
                        h.this.fuS.bpD();
                    }
                    if (h.this.fux != null && h.this.fOs != null && h.this.fuP != null && h.this.fuS != null) {
                        h.this.fux.bkH().c(0, 0, true, true);
                        h.this.fNh.bka();
                        h.this.fNh.jG(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (h.this.fNh.bjN() != null) {
                            h.this.fNh.bjN().fU(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || h.this.fNh.aod().getVisibility() != 0 || v.isEmpty(h.this.fNh.bkn().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.fuS = frsFragment.bjH();
        frsFragment.registerListener(this.fSJ);
    }

    public void bqK() {
        if (this.fux != null) {
            this.fux.setListPullRefreshListener(this.cpa);
            this.fux.a(this.cpc);
            this.fux.a(this.cpb);
        }
    }
}
