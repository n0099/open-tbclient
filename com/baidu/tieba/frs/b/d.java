package com.baidu.tieba.frs.b;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ a bbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bbY = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        BdListView bdListView;
        boolean z;
        int i2;
        String str;
        String str2;
        FrsHeaderView frsHeaderView;
        FrsHeaderView frsHeaderView2;
        FrsActivity frsActivity;
        com.baidu.tieba.frs.view.q qVar;
        com.baidu.tieba.frs.view.q qVar2;
        FrsActivity frsActivity2;
        i = this.bbY.mScrollState;
        if (i == 0) {
            bdListView = this.bbY.bbG;
            if (bdListView.nx()) {
                z = this.bbY.bbQ;
                if (!z) {
                    i2 = this.bbY.aLz;
                    if (i2 == 1) {
                        str = this.bbY.bbO;
                        if (str == "frs_page") {
                            qVar = this.bbY.bbI;
                            if (qVar != null) {
                                qVar2 = this.bbY.bbI;
                                if (qVar2.NS()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aTD, true);
                                    this.bbY.Ns();
                                    frsActivity2 = this.bbY.baR;
                                    frsActivity2.aTI = true;
                                    this.bbY.bbQ = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str2 = this.bbY.bbO;
                        if (str2 == "normal_page") {
                            frsHeaderView = this.bbY.bbH;
                            if (frsHeaderView != null) {
                                frsHeaderView2 = this.bbY.bbH;
                                if (frsHeaderView2.NS()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aTD, true);
                                    this.bbY.Ns();
                                    frsActivity = this.bbY.baR;
                                    frsActivity.aTI = true;
                                    this.bbY.bbQ = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
