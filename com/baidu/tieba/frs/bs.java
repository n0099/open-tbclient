package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tieba.frs.view.FrsHeaderView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements Runnable {
    final /* synthetic */ bp aGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bp bpVar) {
        this.aGj = bpVar;
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
        bdTypeListView = this.aGj.aFo;
        if (bdTypeListView.jK()) {
            dVar = this.aGj.aFU;
            if (dVar != null) {
                dVar2 = this.aGj.aFU;
                dVar2.dismiss();
            }
            z = this.aGj.aFZ;
            if (!z) {
                i = this.aGj.mIsLike;
                if (i == 1) {
                    str = this.aGj.aFH;
                    if (str == "frs_page") {
                        oVar = this.aGj.aFt;
                        if (oVar != null) {
                            oVar2 = this.aGj.aFt;
                            if (oVar2.Hz()) {
                                TbadkSettings.getInst().saveBoolean(FrsActivity.aCJ, true);
                                this.aGj.GD();
                                this.aGj.aFZ = true;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    str2 = this.aGj.aFH;
                    if (str2 == "normal_page") {
                        frsHeaderView = this.aGj.aFs;
                        if (frsHeaderView != null) {
                            frsHeaderView2 = this.aGj.aFs;
                            if (frsHeaderView2.Hz()) {
                                TbadkSettings.getInst().saveBoolean(FrsActivity.aCJ, true);
                                this.aGj.GD();
                                this.aGj.aFZ = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
