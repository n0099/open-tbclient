package com.baidu.tieba.frs.e;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class j implements a.b {
    private final /* synthetic */ com.baidu.tieba.frs.r coM;
    private final /* synthetic */ com.baidu.tieba.frs.view.i coN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(com.baidu.tieba.frs.r rVar, com.baidu.tieba.frs.view.i iVar) {
        this.coM = rVar;
        this.coN = iVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.coM.HidenSoftKeyPad((InputMethodManager) this.coM.getActivity().getSystemService("input_method"), this.coN.getChatMsgView());
        aVar.dismiss();
    }
}
