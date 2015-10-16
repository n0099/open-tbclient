package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aEw;
    private final /* synthetic */ boolean aEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity, boolean z) {
        this.aEw = accountActivity;
        this.aEz = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aEw.destroyWaitingDialog();
        if (this.aEz) {
            this.aEw.fU("account delete cancel");
        }
        this.aEw.aEv = null;
    }
}
