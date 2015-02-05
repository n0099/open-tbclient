package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements Runnable {
    final /* synthetic */ bp aGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bp bpVar) {
        this.aGg = bpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        com.baidu.adp.lib.guide.d dVar;
        boolean z;
        int i;
        String str;
        String str2;
        FrsHeaderView frsHeaderView;
        FrsHeaderView frsHeaderView2;
        com.baidu.tieba.frs.view.o oVar;
        com.baidu.tieba.frs.view.o oVar2;
        com.baidu.adp.lib.guide.d dVar2;
        bdTypeListView = this.aGg.aFl;
        if (bdTypeListView.jD()) {
            dVar = this.aGg.aFR;
            if (dVar != null) {
                dVar2 = this.aGg.aFR;
                dVar2.dismiss();
            }
            z = this.aGg.aFW;
            if (!z) {
                i = this.aGg.mIsLike;
                if (i == 1) {
                    str = this.aGg.aFE;
                    if (str == "frs_page") {
                        oVar = this.aGg.aFq;
                        if (oVar != null) {
                            oVar2 = this.aGg.aFq;
                            if (oVar2.Ht()) {
                                TbadkSettings.getInst().saveBoolean(FrsActivity.aCG, true);
                                this.aGg.Gx();
                                this.aGg.aFW = true;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    str2 = this.aGg.aFE;
                    if (str2 == "normal_page") {
                        frsHeaderView = this.aGg.aFp;
                        if (frsHeaderView != null) {
                            frsHeaderView2 = this.aGg.aFp;
                            if (frsHeaderView2.Ht()) {
                                TbadkSettings.getInst().saveBoolean(FrsActivity.aCG, true);
                                this.aGg.Gx();
                                this.aGg.aFW = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
