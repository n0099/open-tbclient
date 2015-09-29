package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aEl;
    private final /* synthetic */ boolean aEo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity, boolean z) {
        this.aEl = accountActivity;
        this.aEo = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aEl.destroyWaitingDialog();
        if (this.aEo) {
            this.aEl.fU("account delete cancel");
        }
        this.aEl.aEk = null;
    }
}
