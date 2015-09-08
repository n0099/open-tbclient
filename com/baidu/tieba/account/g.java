package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aFg;
    private final /* synthetic */ boolean aFj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity, boolean z) {
        this.aFg = accountActivity;
        this.aFj = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aFg.destroyWaitingDialog();
        if (this.aFj) {
            this.aFg.fQ("account delete cancel");
        }
        this.aFg.aFf = null;
    }
}
