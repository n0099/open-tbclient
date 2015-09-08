package com.baidu.tieba.frs.c;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ a bbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bbT = aVar;
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
        com.baidu.tieba.frs.view.p pVar;
        com.baidu.tieba.frs.view.p pVar2;
        FrsActivity frsActivity2;
        i = this.bbT.mScrollState;
        if (i == 0) {
            bdListView = this.bbT.bbB;
            if (bdListView.nw()) {
                z = this.bbT.bbL;
                if (!z) {
                    i2 = this.bbT.aMu;
                    if (i2 == 1) {
                        str = this.bbT.bbJ;
                        if (str == "frs_page") {
                            pVar = this.bbT.bbD;
                            if (pVar != null) {
                                pVar2 = this.bbT.bbD;
                                if (pVar2.NS()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aUw, true);
                                    this.bbT.Ns();
                                    frsActivity2 = this.bbT.baN;
                                    frsActivity2.aUB = true;
                                    this.bbT.bbL = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str2 = this.bbT.bbJ;
                        if (str2 == "normal_page") {
                            frsHeaderView = this.bbT.bbC;
                            if (frsHeaderView != null) {
                                frsHeaderView2 = this.bbT.bbC;
                                if (frsHeaderView2.NS()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aUw, true);
                                    this.bbT.Ns();
                                    frsActivity = this.bbT.baN;
                                    frsActivity.aUB = true;
                                    this.bbT.bbL = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
