package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements c.b {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.aUz = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        switch (i) {
            case 0:
                this.aUz.aTz = false;
                this.aUz.fq(0);
                return;
            case 1:
                this.aUz.aTz = false;
                this.aUz.KY();
                return;
            default:
                return;
        }
    }
}
