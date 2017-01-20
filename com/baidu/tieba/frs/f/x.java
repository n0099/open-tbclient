package com.baidu.tieba.frs.f;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Runnable {
    final /* synthetic */ u bVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.bVP = uVar;
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
        i = this.bVP.mScrollState;
        if (i == 0) {
            bdTypeListView = this.bVP.bOT;
            if (bdTypeListView.isRefreshDone()) {
                frsActivity = this.bVP.bLZ;
                if (!frsActivity.XR()) {
                    frsActivity2 = this.bVP.bLZ;
                    if (frsActivity2.Xz() != null) {
                        frsActivity4 = this.bVP.bLZ;
                        if (frsActivity4.Xz().aaq()) {
                            return;
                        }
                    }
                    z = this.bVP.bVJ;
                    if (!z) {
                        i2 = this.bVP.bxk;
                        if (i2 == 1) {
                            str = this.bVP.bVH;
                            if (!"frs_page".equals(str)) {
                                str2 = this.bVP.bVH;
                                if (!"normal_page".equals(str2)) {
                                    str3 = this.bVP.bVH;
                                    if (!"book_page".equals(str3)) {
                                        return;
                                    }
                                }
                            }
                            cVar = this.bVP.bVE;
                            if (cVar != null) {
                                cVar2 = this.bVP.bVE;
                                if (cVar2.adv()) {
                                    TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                    this.bVP.ZM();
                                    frsActivity3 = this.bVP.bLZ;
                                    frsActivity3.bFs = true;
                                    this.bVP.bVJ = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
