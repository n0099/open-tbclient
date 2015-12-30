package com.baidu.tieba.frs.b;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ a bmZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bmZ = aVar;
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
        i = this.bmZ.mScrollState;
        if (i == 0) {
            bdListView = this.bmZ.bmG;
            if (bdListView.nc()) {
                z = this.bmZ.bmQ;
                if (!z) {
                    i2 = this.bmZ.aPS;
                    if (i2 == 1) {
                        str = this.bmZ.bmO;
                        if (str == "frs_page") {
                            qVar = this.bmZ.bmI;
                            if (qVar != null) {
                                qVar2 = this.bmZ.bmI;
                                if (qVar2.Qi()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.bcV, true);
                                    this.bmZ.PI();
                                    frsActivity2 = this.bmZ.blE;
                                    frsActivity2.bda = true;
                                    this.bmZ.bmQ = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str2 = this.bmZ.bmO;
                        if (str2 == "normal_page") {
                            frsHeaderView = this.bmZ.bmH;
                            if (frsHeaderView != null) {
                                frsHeaderView2 = this.bmZ.bmH;
                                if (frsHeaderView2.Qi()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.bcV, true);
                                    this.bmZ.PI();
                                    frsActivity = this.bmZ.blE;
                                    frsActivity.bda = true;
                                    this.bmZ.bmQ = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
