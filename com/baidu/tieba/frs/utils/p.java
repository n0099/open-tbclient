package com.baidu.tieba.frs.utils;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    private final /* synthetic */ FrsActivity bOc;
    private final /* synthetic */ com.baidu.tieba.frs.view.o bOd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar) {
        this.bOc = frsActivity;
        this.bOd = oVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bOc.HidenSoftKeyPad((InputMethodManager) this.bOc.getSystemService("input_method"), this.bOd.getChatMsgView());
        aVar.dismiss();
    }
}
