package com.baidu.tieba.frs.i;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ p cfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.cfw = pVar;
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
        i = this.cfw.mScrollState;
        if (i == 0) {
            bdTypeListView = this.cfw.bZE;
            if (bdTypeListView.kw()) {
                frsActivity = this.cfw.bWH;
                if (!frsActivity.aaH()) {
                    frsActivity2 = this.cfw.bWH;
                    if (frsActivity2.aaX() != null) {
                        frsActivity4 = this.cfw.bWH;
                        if (frsActivity4.aaX().isMenuShowing()) {
                            return;
                        }
                    }
                    z = this.cfw.cfr;
                    if (!z) {
                        i2 = this.cfw.bGq;
                        if (i2 == 1) {
                            str = this.cfw.cfp;
                            if (!"frs_page".equals(str)) {
                                str2 = this.cfw.cfp;
                                if (!"normal_page".equals(str2)) {
                                    str3 = this.cfw.cfp;
                                    if (!"book_page".equals(str3)) {
                                        return;
                                    }
                                }
                            }
                            cVar = this.cfw.cfm;
                            if (cVar != null) {
                                cVar2 = this.cfw.cfm;
                                if (cVar2.afG()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.bOT, true);
                                    this.cfw.acS();
                                    frsActivity3 = this.cfw.bWH;
                                    frsActivity3.bPb = true;
                                    this.cfw.cfr = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
