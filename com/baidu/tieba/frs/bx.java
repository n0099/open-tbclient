package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements DialogInterface.OnClickListener {
    final /* synthetic */ bu aDD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bu buVar) {
        this.aDD = buVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        if (i == 0) {
            frsActivity2 = this.aDD.aBz;
            com.baidu.tbadk.core.util.av.h(frsActivity2);
        } else if (i == 1) {
            frsActivity = this.aDD.aBz;
            com.baidu.tbadk.core.util.av.i(frsActivity);
        }
    }
}
