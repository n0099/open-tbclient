package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements c.b {
    final /* synthetic */ bs aXd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bs bsVar) {
        this.aXd = bsVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (i == 0) {
            com.baidu.tbadk.core.util.am.c(this.aXd.aVf.getPageContext());
        } else if (i == 1) {
            com.baidu.tbadk.core.util.am.p(this.aXd.aVf.getPageContext().getPageActivity());
        }
    }
}
