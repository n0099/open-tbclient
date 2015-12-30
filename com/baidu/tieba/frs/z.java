package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements c.b {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        switch (i) {
            case 0:
                this.bed.bdc = false;
                this.bed.fQ(0);
                return;
            case 1:
                this.bed.bdc = false;
                this.bed.Ne();
                return;
            default:
                return;
        }
    }
}
