package com.baidu.tieba.frs.b;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ a bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bcD = aVar;
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
        i = this.bcD.mScrollState;
        if (i == 0) {
            bdListView = this.bcD.bck;
            if (bdListView.ny()) {
                z = this.bcD.bcu;
                if (!z) {
                    i2 = this.bcD.aLH;
                    if (i2 == 1) {
                        str = this.bcD.bcs;
                        if (str == "frs_page") {
                            qVar = this.bcD.bcm;
                            if (qVar != null) {
                                qVar2 = this.bcD.bcm;
                                if (qVar2.Ok()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aTL, true);
                                    this.bcD.NK();
                                    frsActivity2 = this.bcD.bbk;
                                    frsActivity2.aTQ = true;
                                    this.bcD.bcu = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str2 = this.bcD.bcs;
                        if (str2 == "normal_page") {
                            frsHeaderView = this.bcD.bcl;
                            if (frsHeaderView != null) {
                                frsHeaderView2 = this.bcD.bcl;
                                if (frsHeaderView2.Ok()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aTL, true);
                                    this.bcD.NK();
                                    frsActivity = this.bcD.bbk;
                                    frsActivity.aTQ = true;
                                    this.bcD.bcu = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
