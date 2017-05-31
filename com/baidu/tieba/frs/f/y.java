package com.baidu.tieba.frs.f;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ u chY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar) {
        this.chY = uVar;
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
        i = this.chY.mScrollState;
        if (i == 0) {
            bdTypeListView = this.chY.ccf;
            if (bdTypeListView.isRefreshDone()) {
                rVar = this.chY.bTw;
                if (!rVar.aaq()) {
                    z = this.chY.chQ;
                    if (!z) {
                        i2 = this.chY.bMm;
                        if (i2 == 1) {
                            str = this.chY.chO;
                            if (!"frs_page".equals(str)) {
                                str2 = this.chY.chO;
                                if (!"normal_page".equals(str2)) {
                                    str3 = this.chY.chO;
                                    if (!"book_page".equals(str3)) {
                                        return;
                                    }
                                }
                            }
                            bVar = this.chY.chL;
                            if (bVar != null) {
                                bVar2 = this.chY.chL;
                                if (bVar2.aej()) {
                                    TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                    this.chY.abz();
                                    rVar2 = this.chY.bTw;
                                    rVar2.bTN = true;
                                    this.chY.chQ = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
