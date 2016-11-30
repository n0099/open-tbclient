package com.baidu.tieba.frs.j;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ n ckg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar) {
        this.ckg = nVar;
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
        i = this.ckg.mScrollState;
        if (i == 0) {
            bdTypeListView = this.ckg.ccY;
            if (bdTypeListView.kw()) {
                frsActivity = this.ckg.bZY;
                if (!frsActivity.acm()) {
                    frsActivity2 = this.ckg.bZY;
                    if (frsActivity2.abT() != null) {
                        frsActivity4 = this.ckg.bZY;
                        if (frsActivity4.abT().aeT()) {
                            return;
                        }
                    }
                    z = this.ckg.cjZ;
                    if (!z) {
                        i2 = this.ckg.bJv;
                        if (i2 == 1) {
                            str = this.ckg.cjX;
                            if (!"frs_page".equals(str)) {
                                str2 = this.ckg.cjX;
                                if (!"normal_page".equals(str2)) {
                                    str3 = this.ckg.cjX;
                                    if (!"book_page".equals(str3)) {
                                        return;
                                    }
                                }
                            }
                            cVar = this.ckg.cjU;
                            if (cVar != null) {
                                cVar2 = this.ckg.cjU;
                                if (cVar2.ahP()) {
                                    TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                    this.ckg.aer();
                                    frsActivity3 = this.ckg.bZY;
                                    frsActivity3.bRJ = true;
                                    this.ckg.cjZ = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
