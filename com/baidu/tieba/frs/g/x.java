package com.baidu.tieba.frs.g;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Runnable {
    final /* synthetic */ u cdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.cdZ = uVar;
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
        i = this.cdZ.mScrollState;
        if (i == 0) {
            bdTypeListView = this.cdZ.bYg;
            if (bdTypeListView.isRefreshDone()) {
                frsActivity = this.cdZ.bVk;
                if (!frsActivity.aan()) {
                    frsActivity2 = this.cdZ.bVk;
                    if (frsActivity2.ZV() != null) {
                        frsActivity4 = this.cdZ.bVk;
                        if (frsActivity4.ZV().acL()) {
                            return;
                        }
                    }
                    z = this.cdZ.cdT;
                    if (!z) {
                        i2 = this.cdZ.bGA;
                        if (i2 == 1) {
                            str = this.cdZ.cdR;
                            if (!"frs_page".equals(str)) {
                                str2 = this.cdZ.cdR;
                                if (!"normal_page".equals(str2)) {
                                    str3 = this.cdZ.cdR;
                                    if (!"book_page".equals(str3)) {
                                        return;
                                    }
                                }
                            }
                            cVar = this.cdZ.cdO;
                            if (cVar != null) {
                                cVar2 = this.cdZ.cdO;
                                if (cVar2.afr()) {
                                    TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                    this.cdZ.aci();
                                    frsActivity3 = this.cdZ.bVk;
                                    frsActivity3.bOH = true;
                                    this.cdZ.cdT = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
