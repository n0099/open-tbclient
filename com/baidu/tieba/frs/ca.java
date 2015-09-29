package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements c.b {
    final /* synthetic */ bs aWS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bs bsVar) {
        this.aWS = bsVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (i == 0) {
            com.baidu.tbadk.core.util.al.c(this.aWS.aUU.getPageContext());
        } else if (i == 1) {
            com.baidu.tbadk.core.util.al.p(this.aWS.aUU.getPageContext().getPageActivity());
        }
    }
}
