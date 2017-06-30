package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements c.b {
    final /* synthetic */ av cdV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(av avVar) {
        this.cdV = avVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        r rVar;
        r rVar2;
        cVar.dismiss();
        if (i == 0) {
            rVar2 = this.cdV.cdv;
            rVar2.RS();
        } else if (i == 1) {
            rVar = this.cdV.cdv;
            com.baidu.tbadk.core.util.ar.q(rVar.getPageContext().getPageActivity());
        }
    }
}
