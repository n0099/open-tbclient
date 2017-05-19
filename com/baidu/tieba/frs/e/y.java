package com.baidu.tieba.frs.e;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ u cbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar) {
        this.cbL = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        BdTypeListView bdTypeListView;
        com.baidu.tieba.frs.r rVar;
        boolean z;
        int i2;
        String str;
        com.baidu.tieba.frs.view.b bVar;
        com.baidu.tieba.frs.view.b bVar2;
        com.baidu.tieba.frs.r rVar2;
        String str2;
        String str3;
        i = this.cbL.mScrollState;
        if (i == 0) {
            bdTypeListView = this.cbL.bWg;
            if (bdTypeListView.isRefreshDone()) {
                rVar = this.cbL.bNK;
                if (!rVar.Zm()) {
                    z = this.cbL.cbE;
                    if (!z) {
                        i2 = this.cbL.bGx;
                        if (i2 == 1) {
                            str = this.cbL.cbC;
                            if (!"frs_page".equals(str)) {
                                str2 = this.cbL.cbC;
                                if (!"normal_page".equals(str2)) {
                                    str3 = this.cbL.cbC;
                                    if (!"book_page".equals(str3)) {
                                        return;
                                    }
                                }
                            }
                            bVar = this.cbL.cbz;
                            if (bVar != null) {
                                bVar2 = this.cbL.cbz;
                                if (bVar2.adg()) {
                                    TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                    this.cbL.aaw();
                                    rVar2 = this.cbL.bNK;
                                    rVar2.bOa = true;
                                    this.cbL.cbE = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
