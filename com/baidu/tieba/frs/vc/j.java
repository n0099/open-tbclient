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
/* loaded from: classes6.dex */
public class j extends com.baidu.tieba.frs.mc.j {
    private g.c dcr;
    private g.b dcs;
    private g.d dct;
    private boolean gHh;
    private final CustomMessageListener gHi;
    private com.baidu.tieba.frs.smartsort.a gjt;

    public j(FrsFragment frsFragment) {
        super(frsFragment);
        this.gHh = false;
        this.gHi = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH) { // from class: com.baidu.tieba.frs.vc.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && j.this.gja != null) {
                    j.this.gja.startPullRefresh();
                }
            }
        };
        this.dcr = new g.c() { // from class: com.baidu.tieba.frs.vc.j.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (j.this.gBu != null && j.this.gBu.isAdded() && j.this.gja != null) {
                    j.this.gja.hi(true);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        j.this.gBu.refresh();
                        j.this.gBu.kS(true);
                    } else {
                        j.this.gBu.bBl();
                    }
                    TiebaStatic.log(new an("c11749").cp("fid", j.this.gBu.getFid()).cp("obj_locate", "1"));
                }
            }
        };
        this.dct = new g.d() { // from class: com.baidu.tieba.frs.vc.j.3
            @Override // com.baidu.tbadk.core.view.g.d
            public void onListPullToRefresh(boolean z) {
                j.this.gHh = true;
                if (j.this.gja != null && j.this.gCF != null && j.this.gjq != null && j.this.gBu != null && j.this.gBu.isAdded()) {
                    if (j.this.gja != null && j.this.gja.bCd() != null) {
                        j.this.gja.bCd().bLD();
                    }
                    j.this.gBu.kS(false);
                    com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.vc.j.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j.this.gja.bBU() != null && j.this.gCF != null && j.this.gja.bBU().getVisibility() != 0) {
                                j.this.gCF.aPA();
                            }
                        }
                    }, 110L);
                }
            }
        };
        this.dcs = new g.b() { // from class: com.baidu.tieba.frs.vc.j.4
            @Override // com.baidu.tbadk.core.view.g.b
            public void onListPullRefreshFinished(View view, boolean z) {
                if (j.this.gBu != null && j.this.gBu.isAdded()) {
                    if (j.this.gHh && j.this.gBu.bBg() != null) {
                        j.this.gBu.bBg().bIu();
                        j.this.gHh = false;
                    }
                    if (j.this.gjt != null && j.this.gBu.bBi() != null && j.this.gBu.bBi().bCf() != null && !j.this.gBu.bBi().bCf().bHO()) {
                        j.this.gjt.bGZ();
                    }
                    if (j.this.gja != null && j.this.gCF != null && j.this.gjq != null && j.this.gjt != null) {
                        j.this.gja.bCd().a(0, 0, true, true);
                        j.this.gBu.bBv();
                        j.this.gBu.kS(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
                        if (j.this.gBu.bBi() != null) {
                            j.this.gBu.bBi().hi(false);
                        }
                        if (!TbadkCoreApplication.isLogin() || j.this.gBu.aFx().getVisibility() != 0 || v.isEmpty(j.this.gBu.bBI().getThreadList())) {
                        }
                    }
                }
            }
        };
        this.gjt = frsFragment.bBc();
        frsFragment.registerListener(this.gHi);
    }

    public void bIl() {
        if (this.gja != null) {
            this.gja.setListPullRefreshListener(this.dcr);
            this.gja.a(this.dct);
            this.gja.a(this.dcs);
        }
    }
}
