package com.baidu.tieba.frs.c;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ a aNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aNQ = aVar;
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
        i = this.aNQ.mScrollState;
        if (i == 0) {
            bdListView = this.aNQ.aNE;
            if (bdListView.mY()) {
                dVar = this.aNQ.aNJ;
                if (dVar != null) {
                    dVar2 = this.aNQ.aNJ;
                    dVar2.dismiss();
                }
                z = this.aNQ.aNN;
                if (!z) {
                    i2 = this.aNQ.mIsLike;
                    if (i2 == 1) {
                        str = this.aNQ.aLH;
                        if (str == "frs_page") {
                            oVar = this.aNQ.aNG;
                            if (oVar != null) {
                                oVar2 = this.aNQ.aNG;
                                if (oVar2.Lv()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aIN, true);
                                    this.aNQ.Lb();
                                    this.aNQ.aNN = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str2 = this.aNQ.aLH;
                        if (str2 == "normal_page") {
                            frsHeaderView = this.aNQ.aNF;
                            if (frsHeaderView != null) {
                                frsHeaderView2 = this.aNQ.aNF;
                                if (frsHeaderView2.Lv()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aIN, true);
                                    this.aNQ.Lb();
                                    this.aNQ.aNN = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
