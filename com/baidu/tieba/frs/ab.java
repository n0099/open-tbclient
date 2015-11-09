package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements c.b {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (cVar != null && view != null) {
            cVar.dismiss();
            switch (i) {
                case 0:
                    this.aUS.aTS = false;
                    this.aUS.fy(0);
                    return;
                case 1:
                    this.aUS.aTS = true;
                    this.aUS.fz(4);
                    com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
                    return;
                case 2:
                    this.aUS.aTS = false;
                    this.aUS.Lk();
                    return;
                default:
                    return;
            }
        }
    }
}
