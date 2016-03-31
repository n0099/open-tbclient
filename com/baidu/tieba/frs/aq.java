package com.baidu.tieba.frs;

import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ FrsActivity blk;
    private final /* synthetic */ com.baidu.tieba.frs.view.t bls;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(FrsActivity frsActivity, com.baidu.tieba.frs.view.t tVar) {
        this.blk = frsActivity;
        this.bls = tVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.blk.HidenSoftKeyPad((InputMethodManager) this.blk.getSystemService("input_method"), this.bls.getChatMsgView());
        aVar.dismiss();
    }
}
