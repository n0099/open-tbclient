package com.baidu.tieba.frs.g;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Runnable {
    final /* synthetic */ u cbI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.cbI = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        BdTypeListView bdTypeListView;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        boolean z;
        int i2;
        String str;
        com.baidu.tieba.frs.view.c cVar;
        com.baidu.tieba.frs.view.c cVar2;
        FrsActivity frsActivity3;
        String str2;
        String str3;
        FrsActivity frsActivity4;
        i = this.cbI.mScrollState;
        if (i == 0) {
            bdTypeListView = this.cbI.bVP;
            if (bdTypeListView.isRefreshDone()) {
                frsActivity = this.cbI.bST;
                if (!frsActivity.Zm()) {
                    frsActivity2 = this.cbI.bST;
                    if (frsActivity2.YU() != null) {
                        frsActivity4 = this.cbI.bST;
                        if (frsActivity4.YU().abK()) {
                            return;
                        }
                    }
                    z = this.cbI.cbC;
                    if (!z) {
                        i2 = this.cbI.bEj;
                        if (i2 == 1) {
                            str = this.cbI.cbA;
                            if (!"frs_page".equals(str)) {
                                str2 = this.cbI.cbA;
                                if (!"normal_page".equals(str2)) {
                                    str3 = this.cbI.cbA;
                                    if (!"book_page".equals(str3)) {
                                        return;
                                    }
                                }
                            }
                            cVar = this.cbI.cbx;
                            if (cVar != null) {
                                cVar2 = this.cbI.cbx;
                                if (cVar2.aeq()) {
                                    TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                    this.cbI.abh();
                                    frsActivity3 = this.cbI.bST;
                                    frsActivity3.bMq = true;
                                    this.cbI.cbC = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
