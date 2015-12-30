package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements c.b {
    final /* synthetic */ cg bhg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cg cgVar) {
        this.bhg = cgVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (i == 0) {
            com.baidu.tbadk.core.util.ar.c(this.bhg.beB.getPageContext());
        } else if (i == 1) {
            com.baidu.tbadk.core.util.ar.p(this.bhg.beB.getPageContext().getPageActivity());
        }
    }
}
