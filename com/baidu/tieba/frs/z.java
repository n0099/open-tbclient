package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements c.b {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (cVar != null && view != null) {
            cVar.dismiss();
            switch (i) {
                case 0:
                    this.bag.aZg = false;
                    this.bag.fV(0);
                    return;
                case 1:
                    this.bag.aZg = true;
                    this.bag.fW(4);
                    com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
                    return;
                case 2:
                    this.bag.aZg = false;
                    this.bag.MK();
                    return;
                default:
                    return;
            }
        }
    }
}
