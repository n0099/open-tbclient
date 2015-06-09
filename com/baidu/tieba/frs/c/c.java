package com.baidu.tieba.frs.c;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ a aQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aQd = aVar;
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
        i = this.aQd.mScrollState;
        if (i == 0) {
            bdListView = this.aQd.aPR;
            if (bdListView.np()) {
                dVar = this.aQd.aPW;
                if (dVar != null) {
                    dVar2 = this.aQd.aPW;
                    dVar2.dismiss();
                }
                z = this.aQd.aQa;
                if (!z) {
                    i2 = this.aQd.mIsLike;
                    if (i2 == 1) {
                        str = this.aQd.aNS;
                        if (str == "frs_page") {
                            oVar = this.aQd.aPT;
                            if (oVar != null) {
                                oVar2 = this.aQd.aPT;
                                if (oVar2.MB()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aKW, true);
                                    this.aQd.Mh();
                                    frsActivity2 = this.aQd.aPF;
                                    frsActivity2.aLa = true;
                                    this.aQd.aQa = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str2 = this.aQd.aNS;
                        if (str2 == "normal_page") {
                            frsHeaderView = this.aQd.aPS;
                            if (frsHeaderView != null) {
                                frsHeaderView2 = this.aQd.aPS;
                                if (frsHeaderView2.MB()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aKW, true);
                                    this.aQd.Mh();
                                    frsActivity = this.aQd.aPF;
                                    frsActivity.aLa = true;
                                    this.aQd.aQa = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
