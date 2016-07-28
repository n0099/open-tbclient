package com.baidu.tieba.frs.j;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ p bUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.bUo = pVar;
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
        FrsActivity frsActivity4;
        i = this.bUo.mScrollState;
        if (i == 0) {
            bdTypeListView = this.bUo.bOm;
            if (bdTypeListView.jB()) {
                frsActivity = this.bUo.bLx;
                if (!frsActivity.VM()) {
                    frsActivity2 = this.bUo.bLx;
                    if (frsActivity2.Wa() != null) {
                        frsActivity4 = this.bUo.bLx;
                        if (frsActivity4.Wa().isMenuShowing()) {
                            return;
                        }
                    }
                    z = this.bUo.bUj;
                    if (!z) {
                        i2 = this.bUo.bvd;
                        if (i2 == 1) {
                            str = this.bUo.bUh;
                            if (!"frs_page".equals(str)) {
                                str2 = this.bUo.bUh;
                                if (!"normal_page".equals(str2)) {
                                    return;
                                }
                            }
                            cVar = this.bUo.bUe;
                            if (cVar != null) {
                                cVar2 = this.bUo.bUe;
                                if (cVar2.aaV()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.bDp, true);
                                    this.bUo.Yg();
                                    frsActivity3 = this.bUo.bLx;
                                    frsActivity3.bDx = true;
                                    this.bUo.bUj = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
