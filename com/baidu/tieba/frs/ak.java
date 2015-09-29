package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements a.b {
    private final /* synthetic */ com.baidu.tieba.frs.view.p aUI;
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar) {
        this.aUz = frsActivity;
        this.aUI = pVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aUz.HidenSoftKeyPad((InputMethodManager) this.aUz.getSystemService("input_method"), this.aUI.getChatMsgView());
        aVar.dismiss();
    }
}
