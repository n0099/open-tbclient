package com.baidu.tieba.frs.e;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class j implements a.b {
    private final /* synthetic */ com.baidu.tieba.frs.r cgw;
    private final /* synthetic */ com.baidu.tieba.frs.view.i cgx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(com.baidu.tieba.frs.r rVar, com.baidu.tieba.frs.view.i iVar) {
        this.cgw = rVar;
        this.cgx = iVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.cgw.HidenSoftKeyPad((InputMethodManager) this.cgw.getActivity().getSystemService("input_method"), this.cgx.getChatMsgView());
        aVar.dismiss();
    }
}
