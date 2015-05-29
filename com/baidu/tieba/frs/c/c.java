package com.baidu.tieba.frs.c;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ a aQc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aQc = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        BdListView bdListView;
        com.baidu.adp.lib.guide.d dVar;
        boolean z;
        int i2;
        String str;
        String str2;
        FrsHeaderView frsHeaderView;
        FrsHeaderView frsHeaderView2;
        FrsActivity frsActivity;
        o oVar;
        o oVar2;
        FrsActivity frsActivity2;
        com.baidu.adp.lib.guide.d dVar2;
        i = this.aQc.mScrollState;
        if (i == 0) {
            bdListView = this.aQc.aPQ;
            if (bdListView.np()) {
                dVar = this.aQc.aPV;
                if (dVar != null) {
                    dVar2 = this.aQc.aPV;
                    dVar2.dismiss();
                }
                z = this.aQc.aPZ;
                if (!z) {
                    i2 = this.aQc.mIsLike;
                    if (i2 == 1) {
                        str = this.aQc.aNR;
                        if (str == "frs_page") {
                            oVar = this.aQc.aPS;
                            if (oVar != null) {
                                oVar2 = this.aQc.aPS;
                                if (oVar2.MA()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aKV, true);
                                    this.aQc.Mg();
                                    frsActivity2 = this.aQc.aPE;
                                    frsActivity2.aKZ = true;
                                    this.aQc.aPZ = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str2 = this.aQc.aNR;
                        if (str2 == "normal_page") {
                            frsHeaderView = this.aQc.aPR;
                            if (frsHeaderView != null) {
                                frsHeaderView2 = this.aQc.aPR;
                                if (frsHeaderView2.MA()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aKV, true);
                                    this.aQc.Mg();
                                    frsActivity = this.aQc.aPE;
                                    frsActivity.aKZ = true;
                                    this.aQc.aPZ = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
