package com.baidu.tieba.frs.acrossForum;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class z implements a.b {
    private final /* synthetic */ BaseActivity bXg;
    private final /* synthetic */ ac bXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(BaseActivity baseActivity, ac acVar) {
        this.bXg = baseActivity;
        this.bXh = acVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bXg.HidenSoftKeyPad((InputMethodManager) this.bXg.getSystemService("input_method"), this.bXh.getChatMsgView());
        aVar.dismiss();
    }
}
