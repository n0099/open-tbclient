package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aRI;
    private final /* synthetic */ boolean aRK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aRI = accountActivity;
        this.aRK = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aRI.destroyWaitingDialog();
        if (this.aRK) {
            this.aRI.hk("account delete cancel");
        }
        this.aRI.aRF = null;
    }
}
