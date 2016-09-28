package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements a.b {
    private final /* synthetic */ FrsActivity bSP;
    private final /* synthetic */ com.baidu.tieba.frs.view.n bSQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(FrsActivity frsActivity, com.baidu.tieba.frs.view.n nVar) {
        this.bSP = frsActivity;
        this.bSQ = nVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(a aVar) {
        this.bSP.HidenSoftKeyPad((InputMethodManager) this.bSP.getSystemService("input_method"), this.bSQ.getChatMsgView());
        aVar.dismiss();
    }
}
