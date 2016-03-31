package com.baidu.tieba.frs.c;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ a buP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.buP = aVar;
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
        u uVar;
        u uVar2;
        FrsActivity frsActivity3;
        i = this.buP.mScrollState;
        if (i == 0) {
            bdListView = this.buP.buw;
            if (bdListView.nl()) {
                frsActivity = this.buP.bts;
                if (!frsActivity.QS()) {
                    z = this.buP.buG;
                    if (!z) {
                        i2 = this.buP.aVC;
                        if (i2 == 1) {
                            str = this.buP.buE;
                            if (str == "frs_page") {
                                uVar = this.buP.buy;
                                if (uVar != null) {
                                    uVar2 = this.buP.buy;
                                    if (uVar2.Ub()) {
                                        TbadkSettings.getInst().saveBoolean(FrsActivity.bjW, true);
                                        this.buP.TA();
                                        frsActivity3 = this.buP.bts;
                                        frsActivity3.bkb = true;
                                        this.buP.buG = true;
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            str2 = this.buP.buE;
                            if (str2 == "normal_page") {
                                frsHeaderView = this.buP.bux;
                                if (frsHeaderView != null) {
                                    frsHeaderView2 = this.buP.bux;
                                    if (frsHeaderView2.Ub()) {
                                        TbadkSettings.getInst().saveBoolean(FrsActivity.bjW, true);
                                        this.buP.TA();
                                        frsActivity2 = this.buP.bts;
                                        frsActivity2.bkb = true;
                                        this.buP.buG = true;
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
