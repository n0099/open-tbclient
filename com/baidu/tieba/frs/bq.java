package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements c.b {
    final /* synthetic */ bi aXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bi biVar) {
        this.aXy = biVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        if (i == 0) {
            com.baidu.tbadk.core.util.ak.c(this.aXy.aVM.getPageContext());
        } else if (i == 1) {
            com.baidu.tbadk.core.util.ak.p(this.aXy.aVM.getPageContext().getPageActivity());
        }
    }
}
