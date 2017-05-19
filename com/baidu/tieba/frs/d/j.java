package com.baidu.tieba.frs.d;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class j implements a.b {
    private final /* synthetic */ com.baidu.tieba.frs.r cak;
    private final /* synthetic */ com.baidu.tieba.frs.view.i cal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(com.baidu.tieba.frs.r rVar, com.baidu.tieba.frs.view.i iVar) {
        this.cak = rVar;
        this.cal = iVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cak.HidenSoftKeyPad((InputMethodManager) this.cak.getActivity().getSystemService("input_method"), this.cal.getChatMsgView());
        aVar.dismiss();
    }
}
