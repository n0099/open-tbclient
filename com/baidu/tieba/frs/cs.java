package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements a.b {
    private final /* synthetic */ FrsActivity bSW;
    private final /* synthetic */ com.baidu.tieba.frs.view.n bSX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(FrsActivity frsActivity, com.baidu.tieba.frs.view.n nVar) {
        this.bSW = frsActivity;
        this.bSX = nVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(a aVar) {
        this.bSW.HidenSoftKeyPad((InputMethodManager) this.bSW.getSystemService("input_method"), this.bSX.getChatMsgView());
        aVar.dismiss();
    }
}
