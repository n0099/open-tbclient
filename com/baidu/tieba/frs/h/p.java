package com.baidu.tieba.frs.h;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.view.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ m buB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.buB = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        BdExpandListView bdExpandListView;
        FrsActivity frsActivity;
        boolean z;
        int i2;
        String str;
        com.baidu.tieba.frs.view.c cVar;
        com.baidu.tieba.frs.view.c cVar2;
        FrsActivity frsActivity2;
        String str2;
        i = this.buB.mScrollState;
        if (i == 0) {
            bdExpandListView = this.buB.bjM;
            if (bdExpandListView.jz()) {
                frsActivity = this.buB.bpj;
                if (!frsActivity.PS()) {
                    z = this.buB.buv;
                    if (!z) {
                        i2 = this.buB.aWR;
                        if (i2 == 1) {
                            str = this.buB.but;
                            if (!"frs_page".equals(str)) {
                                str2 = this.buB.but;
                                if (!"normal_page".equals(str2)) {
                                    return;
                                }
                            }
                            cVar = this.buB.buq;
                            if (cVar != null) {
                                cVar2 = this.buB.buq;
                                if (cVar2.Ue()) {
                                    TbadkSettings.getInst().saveBoolean(FrsActivity.bfV, true);
                                    this.buB.Ss();
                                    frsActivity2 = this.buB.bpj;
                                    frsActivity2.bgb = true;
                                    this.buB.buv = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
