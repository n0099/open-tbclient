package com.baidu.tieba.frs.c;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ a bbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bbz = aVar;
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
        i = this.bbz.mScrollState;
        if (i == 0) {
            bdListView = this.bbz.bbh;
            if (bdListView.nz()) {
                z = this.bbz.bbr;
                if (!z) {
                    i2 = this.bbz.aMh;
                    if (i2 == 1) {
                        str = this.bbz.bbp;
                        if (str == "frs_page") {
                            pVar = this.bbz.bbj;
                            if (pVar != null) {
                                pVar2 = this.bbz.bbj;
                                if (pVar2.NR()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aUi, true);
                                    this.bbz.Nr();
                                    frsActivity2 = this.bbz.bat;
                                    frsActivity2.aUn = true;
                                    this.bbz.bbr = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str2 = this.bbz.bbp;
                        if (str2 == "normal_page") {
                            frsHeaderView = this.bbz.bbi;
                            if (frsHeaderView != null) {
                                frsHeaderView2 = this.bbz.bbi;
                                if (frsHeaderView2.NR()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.aUi, true);
                                    this.bbz.Nr();
                                    frsActivity = this.bbz.bat;
                                    frsActivity.aUn = true;
                                    this.bbz.bbr = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
