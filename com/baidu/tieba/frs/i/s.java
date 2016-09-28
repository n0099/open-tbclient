package com.baidu.tieba.frs.i;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ p cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.cft = pVar;
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
        i = this.cft.mScrollState;
        if (i == 0) {
            bdTypeListView = this.cft.bZB;
            if (bdTypeListView.kw()) {
                frsActivity = this.cft.bWH;
                if (!frsActivity.aaV()) {
                    frsActivity2 = this.cft.bWH;
                    if (frsActivity2.abk() != null) {
                        frsActivity4 = this.cft.bWH;
                        if (frsActivity4.abk().isMenuShowing()) {
                            return;
                        }
                    }
                    z = this.cft.cfo;
                    if (!z) {
                        i2 = this.cft.bGB;
                        if (i2 == 1) {
                            str = this.cft.cfm;
                            if (!"frs_page".equals(str)) {
                                str2 = this.cft.cfm;
                                if (!"normal_page".equals(str2)) {
                                    str3 = this.cft.cfm;
                                    if (!"book_page".equals(str3)) {
                                        return;
                                    }
                                }
                            }
                            cVar = this.cft.cfj;
                            if (cVar != null) {
                                cVar2 = this.cft.cfj;
                                if (cVar2.afU()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.bON, true);
                                    this.cft.ade();
                                    frsActivity3 = this.cft.bWH;
                                    frsActivity3.bOV = true;
                                    this.cft.cfo = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
