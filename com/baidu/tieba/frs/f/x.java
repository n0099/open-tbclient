package com.baidu.tieba.frs.f;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Runnable {
    final /* synthetic */ u cdh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.cdh = uVar;
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
        i = this.cdh.mScrollState;
        if (i == 0) {
            bdTypeListView = this.cdh.bWb;
            if (bdTypeListView.isRefreshDone()) {
                frsActivity = this.cdh.bTf;
                if (!frsActivity.YQ()) {
                    frsActivity2 = this.cdh.bTf;
                    if (frsActivity2.Yy() != null) {
                        frsActivity4 = this.cdh.bTf;
                        if (frsActivity4.Yy().abn()) {
                            return;
                        }
                    }
                    z = this.cdh.cdb;
                    if (!z) {
                        i2 = this.cdh.bEq;
                        if (i2 == 1) {
                            str = this.cdh.ccZ;
                            if (!"frs_page".equals(str)) {
                                str2 = this.cdh.ccZ;
                                if (!"normal_page".equals(str2)) {
                                    str3 = this.cdh.ccZ;
                                    if (!"book_page".equals(str3)) {
                                        return;
                                    }
                                }
                            }
                            cVar = this.cdh.ccW;
                            if (cVar != null) {
                                cVar2 = this.cdh.ccW;
                                if (cVar2.aev()) {
                                    TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                    this.cdh.aaJ();
                                    frsActivity3 = this.cdh.bTf;
                                    frsActivity3.bMA = true;
                                    this.cdh.cdb = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
