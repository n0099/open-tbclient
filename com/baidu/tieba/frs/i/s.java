package com.baidu.tieba.frs.i;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ p bSo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.bSo = pVar;
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
        i = this.bSo.mScrollState;
        if (i == 0) {
            bdTypeListView = this.bSo.bMC;
            if (bdTypeListView.jC()) {
                frsActivity = this.bSo.bJR;
                if (!frsActivity.Vv()) {
                    frsActivity2 = this.bSo.bJR;
                    if (frsActivity2.VI() != null) {
                        frsActivity4 = this.bSo.bJR;
                        if (frsActivity4.VI().isMenuShowing()) {
                            return;
                        }
                    }
                    z = this.bSo.bSj;
                    if (!z) {
                        i2 = this.bSo.bsO;
                        if (i2 == 1) {
                            str = this.bSo.bSh;
                            if (!"frs_page".equals(str)) {
                                str2 = this.bSo.bSh;
                                if (!"normal_page".equals(str2)) {
                                    return;
                                }
                            }
                            cVar = this.bSo.bSe;
                            if (cVar != null) {
                                cVar2 = this.bSo.bSe;
                                if (cVar2.aat()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.bCk, true);
                                    this.bSo.XN();
                                    frsActivity3 = this.bSo.bJR;
                                    frsActivity3.bCq = true;
                                    this.bSo.bSj = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
