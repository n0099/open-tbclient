package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements c.b {
    final /* synthetic */ at bPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(at atVar) {
        this.bPW = atVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        r rVar;
        r rVar2;
        cVar.dismiss();
        if (i == 0) {
            rVar2 = this.bPW.bPw;
            rVar2.PS();
        } else if (i == 1) {
            rVar = this.bPW.bPw;
            com.baidu.tbadk.core.util.ap.p(rVar.getPageContext().getPageActivity());
        }
    }
}
