package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements a.b {
    final /* synthetic */ FrsActivity bhl;
    private final /* synthetic */ com.baidu.tieba.frs.view.v bhw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(FrsActivity frsActivity, com.baidu.tieba.frs.view.v vVar) {
        this.bhl = frsActivity;
        this.bhw = vVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        this.bhl.HidenSoftKeyPad((InputMethodManager) this.bhl.getSystemService("input_method"), this.bhw.getChatMsgView());
        aVar.dismiss();
    }
}
