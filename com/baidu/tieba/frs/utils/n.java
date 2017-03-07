package com.baidu.tieba.frs.utils;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class n implements a.b {
    private final /* synthetic */ FrsActivity cbE;
    private final /* synthetic */ com.baidu.tieba.frs.view.o cbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar) {
        this.cbE = frsActivity;
        this.cbF = oVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cbE.HidenSoftKeyPad((InputMethodManager) this.cbE.getSystemService("input_method"), this.cbF.getChatMsgView());
        aVar.dismiss();
    }
}
