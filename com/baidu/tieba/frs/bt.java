package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements Runnable {
    final /* synthetic */ bq aFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bq bqVar) {
        this.aFg = bqVar;
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
        bdTypeListView = this.aFg.aEm;
        if (bdTypeListView.jL()) {
            dVar = this.aFg.aER;
            if (dVar != null) {
                dVar2 = this.aFg.aER;
                dVar2.dismiss();
            }
            z = this.aFg.aEW;
            if (!z) {
                i = this.aFg.mIsLike;
                if (i == 1) {
                    str = this.aFg.aEE;
                    if (str == "frs_page") {
                        oVar = this.aFg.aEq;
                        if (oVar != null) {
                            oVar2 = this.aFg.aEq;
                            if (oVar2.Hb()) {
                                TbadkSettings.getInst().saveBoolean(FrsActivity.aBI, true);
                                this.aFg.Gg();
                                this.aFg.aEW = true;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    str2 = this.aFg.aEE;
                    if (str2 == "normal_page") {
                        frsHeaderView = this.aFg.aEp;
                        if (frsHeaderView != null) {
                            frsHeaderView2 = this.aFg.aEp;
                            if (frsHeaderView2.Hb()) {
                                TbadkSettings.getInst().saveBoolean(FrsActivity.aBI, true);
                                this.aFg.Gg();
                                this.aFg.aEW = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
