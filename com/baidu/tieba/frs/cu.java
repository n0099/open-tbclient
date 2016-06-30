package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements a.b {
    private final /* synthetic */ FrsActivity bGu;
    private final /* synthetic */ com.baidu.tieba.frs.view.n bGv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(FrsActivity frsActivity, com.baidu.tieba.frs.view.n nVar) {
        this.bGu = frsActivity;
        this.bGv = nVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        this.bGu.HidenSoftKeyPad((InputMethodManager) this.bGu.getSystemService("input_method"), this.bGv.getChatMsgView());
        aVar.dismiss();
    }
}
