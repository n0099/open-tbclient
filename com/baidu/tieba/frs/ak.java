package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements a.b {
    final /* synthetic */ FrsActivity aUK;
    private final /* synthetic */ com.baidu.tieba.frs.view.p aUT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar) {
        this.aUK = frsActivity;
        this.aUT = pVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aUK.HidenSoftKeyPad((InputMethodManager) this.aUK.getSystemService("input_method"), this.aUT.getChatMsgView());
        aVar.dismiss();
    }
}
