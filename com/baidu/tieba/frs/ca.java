package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements c.b {
    final /* synthetic */ bs aXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bs bsVar) {
        this.aXm = bsVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (i == 0) {
            com.baidu.tbadk.core.util.am.c(this.aXm.aVn.getPageContext());
        } else if (i == 1) {
            com.baidu.tbadk.core.util.am.p(this.aXm.aVn.getPageContext().getPageActivity());
        }
    }
}
