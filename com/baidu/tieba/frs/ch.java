package com.baidu.tieba.frs;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface instanceof Dialog) {
            com.baidu.adp.lib.e.e.b((Dialog) dialogInterface, this.a);
        }
    }
}
