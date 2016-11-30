package com.baidu.tieba.frs.utils;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class o implements a.b {
    private final /* synthetic */ FrsActivity ciV;
    private final /* synthetic */ com.baidu.tieba.frs.view.o ciW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar) {
        this.ciV = frsActivity;
        this.ciW = oVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ciV.HidenSoftKeyPad((InputMethodManager) this.ciV.getSystemService("input_method"), this.ciW.getChatMsgView());
        aVar.dismiss();
    }
}
