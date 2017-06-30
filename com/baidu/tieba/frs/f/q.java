package com.baidu.tieba.frs.f;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ m cpZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(m mVar) {
        this.cpZ = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        BdTypeListView bdTypeListView;
        boolean z;
        int i2;
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        com.baidu.tieba.frs.r rVar3;
        String str;
        com.baidu.tieba.frs.view.b bVar;
        com.baidu.tieba.frs.view.b bVar2;
        com.baidu.tieba.frs.r rVar4;
        String str2;
        String str3;
        i = this.cpZ.mScrollState;
        if (i == 0) {
            bdTypeListView = this.cpZ.ckr;
            if (bdTypeListView.isRefreshDone()) {
                z = this.cpZ.cpR;
                if (!z) {
                    i2 = this.cpZ.bSN;
                    if (i2 == 1) {
                        rVar = this.cpZ.cbE;
                        if (rVar.adU() != null) {
                            rVar2 = this.cpZ.cbE;
                            if (rVar2.adU().aeu() != null) {
                                rVar3 = this.cpZ.cbE;
                                if (!rVar3.adU().aeu().afO()) {
                                    str = this.cpZ.cpP;
                                    if (!"frs_page".equals(str)) {
                                        str2 = this.cpZ.cpP;
                                        if (!"normal_page".equals(str2)) {
                                            str3 = this.cpZ.cpP;
                                            if (!"book_page".equals(str3)) {
                                                return;
                                            }
                                        }
                                    }
                                    bVar = this.cpZ.cpM;
                                    if (bVar != null) {
                                        bVar2 = this.cpZ.cpM;
                                        if (bVar2.ahX()) {
                                            TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                            this.cpZ.afq();
                                            rVar4 = this.cpZ.cbE;
                                            rVar4.cbW = true;
                                            this.cpZ.cpR = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
