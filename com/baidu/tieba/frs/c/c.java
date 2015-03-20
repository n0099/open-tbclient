package com.baidu.tieba.frs.c;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ a aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aNz = aVar;
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
        com.baidu.tieba.frs.view.o oVar;
        com.baidu.tieba.frs.view.o oVar2;
        com.baidu.adp.lib.guide.d dVar2;
        i = this.aNz.mScrollState;
        if (i == 0) {
            bdListView = this.aNz.aNn;
            if (bdListView.mY()) {
                dVar = this.aNz.aNs;
                if (dVar != null) {
                    dVar2 = this.aNz.aNs;
                    dVar2.dismiss();
                }
                z = this.aNz.aNw;
                if (!z) {
                    i2 = this.aNz.mIsLike;
                    if (i2 == 1) {
                        str = this.aNz.aLx;
                        if (str == "frs_page") {
                            oVar = this.aNz.aNp;
                            if (oVar != null) {
                                oVar2 = this.aNz.aNp;
                                if (oVar2.Lj()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aIF, true);
                                    this.aNz.KP();
                                    this.aNz.aNw = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str2 = this.aNz.aLx;
                        if (str2 == "normal_page") {
                            frsHeaderView = this.aNz.aNo;
                            if (frsHeaderView != null) {
                                frsHeaderView2 = this.aNz.aNo;
                                if (frsHeaderView2.Lj()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aIF, true);
                                    this.aNz.KP();
                                    this.aNz.aNw = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
