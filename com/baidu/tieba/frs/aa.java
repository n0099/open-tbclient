package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements c.b {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (cVar != null && view != null) {
            cVar.dismiss();
            switch (i) {
                case 0:
                    this.bed.bdc = false;
                    this.bed.fQ(0);
                    return;
                case 1:
                    this.bed.Nd();
                    return;
                case 2:
                    this.bed.bdc = false;
                    this.bed.Ne();
                    return;
                default:
                    return;
            }
        }
    }
}
