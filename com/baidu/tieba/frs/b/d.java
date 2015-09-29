package com.baidu.tieba.frs.b;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ a bbN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bbN = aVar;
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
        i = this.bbN.mScrollState;
        if (i == 0) {
            bdListView = this.bbN.bbv;
            if (bdListView.nx()) {
                z = this.bbN.bbF;
                if (!z) {
                    i2 = this.bbN.aLo;
                    if (i2 == 1) {
                        str = this.bbN.bbD;
                        if (str == "frs_page") {
                            qVar = this.bbN.bbx;
                            if (qVar != null) {
                                qVar2 = this.bbN.bbx;
                                if (qVar2.NS()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aTs, true);
                                    this.bbN.Ns();
                                    frsActivity2 = this.bbN.baG;
                                    frsActivity2.aTx = true;
                                    this.bbN.bbF = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str2 = this.bbN.bbD;
                        if (str2 == "normal_page") {
                            frsHeaderView = this.bbN.bbw;
                            if (frsHeaderView != null) {
                                frsHeaderView2 = this.bbN.bbw;
                                if (frsHeaderView2.NS()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aTs, true);
                                    this.bbN.Ns();
                                    frsActivity = this.bbN.baG;
                                    frsActivity.aTx = true;
                                    this.bbN.bbF = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
