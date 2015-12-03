package com.baidu.tieba.frs.b;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ a bji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bji = aVar;
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
        i = this.bji.mScrollState;
        if (i == 0) {
            bdListView = this.bji.biP;
            if (bdListView.nE()) {
                z = this.bji.biZ;
                if (!z) {
                    i2 = this.bji.aMO;
                    if (i2 == 1) {
                        str = this.bji.biX;
                        if (str == "frs_page") {
                            qVar = this.bji.biR;
                            if (qVar != null) {
                                qVar2 = this.bji.biR;
                                if (qVar2.PQ()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aYZ, true);
                                    this.bji.Pq();
                                    frsActivity2 = this.bji.bhN;
                                    frsActivity2.aZe = true;
                                    this.bji.biZ = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str2 = this.bji.biX;
                        if (str2 == "normal_page") {
                            frsHeaderView = this.bji.biQ;
                            if (frsHeaderView != null) {
                                frsHeaderView2 = this.bji.biQ;
                                if (frsHeaderView2.PQ()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aYZ, true);
                                    this.bji.Pq();
                                    frsActivity = this.bji.bhN;
                                    frsActivity.aZe = true;
                                    this.bji.biZ = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
