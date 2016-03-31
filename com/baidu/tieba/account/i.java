package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aLN;
    private final /* synthetic */ boolean aLQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aLN = accountActivity;
        this.aLQ = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aLN.destroyWaitingDialog();
        if (this.aLQ) {
            this.aLN.gz("account delete cancel");
        }
        this.aLN.aLK = null;
    }
}
