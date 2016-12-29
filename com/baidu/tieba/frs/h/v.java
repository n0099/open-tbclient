package com.baidu.tieba.frs.h;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {
    final /* synthetic */ s bPp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.bPp = sVar;
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
        i = this.bPp.mScrollState;
        if (i == 0) {
            bdTypeListView = this.bPp.bIF;
            if (bdTypeListView.kw()) {
                frsActivity = this.bPp.bFI;
                if (!frsActivity.WA()) {
                    frsActivity2 = this.bPp.bFI;
                    if (frsActivity2.Wi() != null) {
                        frsActivity4 = this.bPp.bFI;
                        if (frsActivity4.Wi().Zo()) {
                            return;
                        }
                    }
                    z = this.bPp.bPi;
                    if (!z) {
                        i2 = this.bPp.bpy;
                        if (i2 == 1) {
                            str = this.bPp.bPg;
                            if (!"frs_page".equals(str)) {
                                str2 = this.bPp.bPg;
                                if (!"normal_page".equals(str2)) {
                                    str3 = this.bPp.bPg;
                                    if (!"book_page".equals(str3)) {
                                        return;
                                    }
                                }
                            }
                            cVar = this.bPp.bPd;
                            if (cVar != null) {
                                cVar2 = this.bPp.bPd;
                                if (cVar2.acm()) {
                                    TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                    this.bPp.YK();
                                    frsActivity3 = this.bPp.bFI;
                                    frsActivity3.bxU = true;
                                    this.bPp.bPi = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
