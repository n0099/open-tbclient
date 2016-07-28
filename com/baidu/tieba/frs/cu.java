package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements a.b {
    private final /* synthetic */ FrsActivity bHQ;
    private final /* synthetic */ com.baidu.tieba.frs.view.n bHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(FrsActivity frsActivity, com.baidu.tieba.frs.view.n nVar) {
        this.bHQ = frsActivity;
        this.bHR = nVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        this.bHQ.HidenSoftKeyPad((InputMethodManager) this.bHQ.getSystemService("input_method"), this.bHR.getChatMsgView());
        aVar.dismiss();
    }
}
