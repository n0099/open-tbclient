package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements a.b {
    private final /* synthetic */ com.baidu.tieba.frs.view.s bgH;
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(FrsActivity frsActivity, com.baidu.tieba.frs.view.s sVar) {
        this.bgz = frsActivity;
        this.bgH = sVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.bgz.HidenSoftKeyPad((InputMethodManager) this.bgz.getSystemService("input_method"), this.bgH.getChatMsgView());
        aVar.dismiss();
    }
}
