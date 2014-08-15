package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements DialogInterface.OnClickListener {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cu cuVar) {
        this.a = cuVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        if (i == 0) {
            frsActivity2 = this.a.i;
            com.baidu.tbadk.core.util.ax.a(frsActivity2);
        } else if (i == 1) {
            frsActivity = this.a.i;
            com.baidu.tbadk.core.util.ax.b(frsActivity);
        }
    }
}
