package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements c.b {
    final /* synthetic */ cd bdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(cd cdVar) {
        this.bdg = cdVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (i == 0) {
            com.baidu.tbadk.core.util.ar.c(this.bdg.baC.getPageContext());
        } else if (i == 1) {
            com.baidu.tbadk.core.util.ar.p(this.bdg.baC.getPageContext().getPageActivity());
        }
    }
}
