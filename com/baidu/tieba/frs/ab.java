package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements c.b {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.aUK = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (cVar != null && view != null) {
            cVar.dismiss();
            switch (i) {
                case 0:
                    this.aUK.aTK = false;
                    this.aUK.fq(0);
                    return;
                case 1:
                    this.aUK.aTK = true;
                    this.aUK.fr(4);
                    com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
                    return;
                case 2:
                    this.aUK.aTK = false;
                    this.aUK.KY();
                    return;
                default:
                    return;
            }
        }
    }
}
