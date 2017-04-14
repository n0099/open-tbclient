package com.baidu.tieba.frs.f;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    private final /* synthetic */ FrsActivity caf;
    private final /* synthetic */ com.baidu.tieba.frs.view.o cag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity, com.baidu.tieba.frs.view.o oVar) {
        this.caf = frsActivity;
        this.cag = oVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.caf.HidenSoftKeyPad((InputMethodManager) this.caf.getSystemService("input_method"), this.cag.getChatMsgView());
        aVar.dismiss();
    }
}
