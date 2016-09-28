package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aSN;
    private final /* synthetic */ boolean aSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aSN = accountActivity;
        this.aSP = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aSN.destroyWaitingDialog();
        if (this.aSP) {
            this.aSN.hr("account delete cancel");
        }
        this.aSN.aSK = null;
    }
}
