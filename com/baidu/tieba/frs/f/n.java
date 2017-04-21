package com.baidu.tieba.frs.f;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class n implements a.b {
    private final /* synthetic */ FrsActivity ccw;
    private final /* synthetic */ com.baidu.tieba.frs.view.o ccx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar) {
        this.ccw = frsActivity;
        this.ccx = oVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ccw.HidenSoftKeyPad((InputMethodManager) this.ccw.getSystemService("input_method"), this.ccx.getChatMsgView());
        aVar.dismiss();
    }
}
