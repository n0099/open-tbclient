package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements c.b {
    final /* synthetic */ au bVN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(au auVar) {
        this.bVN = auVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        r rVar;
        r rVar2;
        cVar.dismiss();
        if (i == 0) {
            rVar2 = this.bVN.bVm;
            rVar2.Qe();
        } else if (i == 1) {
            rVar = this.bVN.bVm;
            com.baidu.tbadk.core.util.ap.q(rVar.getPageContext().getPageActivity());
        }
    }
}
