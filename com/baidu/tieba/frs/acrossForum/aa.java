package com.baidu.tieba.frs.acrossForum;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class aa implements a.b {
    private final /* synthetic */ BaseActivity bDq;
    private final /* synthetic */ ab bDr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(BaseActivity baseActivity, ab abVar) {
        this.bDq = baseActivity;
        this.bDr = abVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bDq.HidenSoftKeyPad((InputMethodManager) this.bDq.getSystemService("input_method"), this.bDr.getChatMsgView());
        aVar.dismiss();
    }
}
