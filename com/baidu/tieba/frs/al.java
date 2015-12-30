package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements a.b {
    final /* synthetic */ FrsActivity bed;
    private final /* synthetic */ com.baidu.tieba.frs.view.p bem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity, com.baidu.tieba.frs.view.p pVar) {
        this.bed = frsActivity;
        this.bem = pVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bed.HidenSoftKeyPad((InputMethodManager) this.bed.getSystemService("input_method"), this.bem.getChatMsgView());
        aVar.dismiss();
    }
}
