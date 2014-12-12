package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements DialogInterface.OnClickListener {
    final /* synthetic */ bq aFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bq bqVar) {
        this.aFg = bqVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        if (i == 0) {
            frsActivity2 = this.aFg.aDc;
            com.baidu.tbadk.core.util.aw.a(frsActivity2.getPageContext());
        } else if (i == 1) {
            frsActivity = this.aFg.aDc;
            com.baidu.tbadk.core.util.aw.o(frsActivity.getPageContext().getPageActivity());
        }
    }
}
