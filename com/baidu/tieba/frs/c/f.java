package com.baidu.tieba.frs.c;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ a bpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bpO = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        BdListView bdListView;
        FrsActivity frsActivity;
        boolean z;
        int i2;
        String str;
        String str2;
        FrsHeaderView frsHeaderView;
        FrsHeaderView frsHeaderView2;
        FrsActivity frsActivity2;
        t tVar;
        t tVar2;
        FrsActivity frsActivity3;
        i = this.bpO.mScrollState;
        if (i == 0) {
            bdListView = this.bpO.bpv;
            if (bdListView.nt()) {
                frsActivity = this.bpO.bot;
                if (!frsActivity.Pd()) {
                    z = this.bpO.bpF;
                    if (!z) {
                        i2 = this.bpO.aRV;
                        if (i2 == 1) {
                            str = this.bpO.bpD;
                            if (str == "frs_page") {
                                tVar = this.bpO.bpx;
                                if (tVar != null) {
                                    tVar2 = this.bpO.bpx;
                                    if (tVar2.Sm()) {
                                        TbadkSettings.getInst().saveBoolean(FrsActivity.bfm, true);
                                        this.bpO.RM();
                                        frsActivity3 = this.bpO.bot;
                                        frsActivity3.bfr = true;
                                        this.bpO.bpF = true;
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            str2 = this.bpO.bpD;
                            if (str2 == "normal_page") {
                                frsHeaderView = this.bpO.bpw;
                                if (frsHeaderView != null) {
                                    frsHeaderView2 = this.bpO.bpw;
                                    if (frsHeaderView2.Sm()) {
                                        TbadkSettings.getInst().saveBoolean(FrsActivity.bfm, true);
                                        this.bpO.RM();
                                        frsActivity2 = this.bpO.bot;
                                        frsActivity2.bfr = true;
                                        this.bpO.bpF = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
