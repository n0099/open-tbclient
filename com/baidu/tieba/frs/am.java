package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements a.b {
    final /* synthetic */ FrsActivity aUS;
    private final /* synthetic */ com.baidu.tieba.frs.view.p aVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar) {
        this.aUS = frsActivity;
        this.aVb = pVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aUS.HidenSoftKeyPad((InputMethodManager) this.aUS.getSystemService("input_method"), this.aVb.getChatMsgView());
        aVar.dismiss();
    }
}
