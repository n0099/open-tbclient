package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements a.b {
    final /* synthetic */ FrsActivity bag;
    private final /* synthetic */ com.baidu.tieba.frs.view.p ban;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar) {
        this.bag = frsActivity;
        this.ban = pVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bag.HidenSoftKeyPad((InputMethodManager) this.bag.getSystemService("input_method"), this.ban.getChatMsgView());
        aVar.dismiss();
    }
}
