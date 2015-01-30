package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements DialogInterface.OnClickListener {
    final /* synthetic */ bp aGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bp bpVar) {
        this.aGj = bpVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        if (i == 0) {
            frsActivity2 = this.aGj.aEd;
            com.baidu.tbadk.core.util.bb.a(frsActivity2.getPageContext());
        } else if (i == 1) {
            frsActivity = this.aGj.aEd;
            com.baidu.tbadk.core.util.bb.p(frsActivity.getPageContext().getPageActivity());
        }
    }
}
