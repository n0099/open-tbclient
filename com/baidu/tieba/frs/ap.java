package com.baidu.tieba.frs;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface instanceof Dialog) {
            com.baidu.adp.lib.g.k.b((Dialog) dialogInterface, this.aDW.getPageContext().getPageActivity());
        }
    }
}
