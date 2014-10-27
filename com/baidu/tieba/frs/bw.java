package com.baidu.tieba.frs;

import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Runnable {
    final /* synthetic */ bu aDt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bu buVar) {
        this.aDt = buVar;
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
        dVar = this.aDt.aDh;
        if (dVar != null) {
            dVar2 = this.aDt.aDh;
            dVar2.dismiss();
        }
        if (!TbadkSettings.getInst().loadBoolean(FrsActivity.aAh, false)) {
            i = this.aDt.mIsLike;
            if (i == 1) {
                str = this.aDt.aCT;
                if (str == "frs_page") {
                    rVar = this.aDt.aCF;
                    if (rVar != null) {
                        rVar2 = this.aDt.aCF;
                        if (rVar2.GS()) {
                            TbadkSettings.getInst().saveBoolean(FrsActivity.aAh, true);
                            this.aDt.FZ();
                            return;
                        }
                        return;
                    }
                    return;
                }
                str2 = this.aDt.aCT;
                if (str2 == "normal_page") {
                    frsHeaderView = this.aDt.aCE;
                    if (frsHeaderView != null) {
                        frsHeaderView2 = this.aDt.aCE;
                        if (frsHeaderView2.GS()) {
                            TbadkSettings.getInst().saveBoolean(FrsActivity.aAh, true);
                            this.aDt.FZ();
                        }
                    }
                }
            }
        }
    }
}
