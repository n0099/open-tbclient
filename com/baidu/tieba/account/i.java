package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aVU;
    private final /* synthetic */ boolean aVW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aVU = accountActivity;
        this.aVW = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aVU.destroyWaitingDialog();
        if (this.aVW) {
            this.aVU.ha("account delete cancel");
        }
        this.aVU.aVR = null;
    }
}
