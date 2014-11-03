package com.baidu.tieba.frs;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Runnable {
    final /* synthetic */ bu aDD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bu buVar) {
        this.aDD = buVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        int i;
        String str;
        String str2;
        FrsHeaderView frsHeaderView;
        FrsHeaderView frsHeaderView2;
        com.baidu.tieba.frs.view.r rVar;
        com.baidu.tieba.frs.view.r rVar2;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.aDD.aDr;
        if (dVar != null) {
            dVar2 = this.aDD.aDr;
            dVar2.dismiss();
        }
        if (!TbadkSettings.getInst().loadBoolean(FrsActivity.aAq, false)) {
            i = this.aDD.mIsLike;
            if (i == 1) {
                str = this.aDD.aDd;
                if (str == "frs_page") {
                    rVar = this.aDD.aCP;
                    if (rVar != null) {
                        rVar2 = this.aDD.aCP;
                        if (rVar2.GU()) {
                            TbadkSettings.getInst().saveBoolean(FrsActivity.aAq, true);
                            this.aDD.Gb();
                            return;
                        }
                        return;
                    }
                    return;
                }
                str2 = this.aDD.aDd;
                if (str2 == "normal_page") {
                    frsHeaderView = this.aDD.aCO;
                    if (frsHeaderView != null) {
                        frsHeaderView2 = this.aDD.aCO;
                        if (frsHeaderView2.GU()) {
                            TbadkSettings.getInst().saveBoolean(FrsActivity.aAq, true);
                            this.aDD.Gb();
                        }
                    }
                }
            }
        }
    }
}
