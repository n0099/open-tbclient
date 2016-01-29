package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aIQ;
    private final /* synthetic */ boolean aIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aIQ = accountActivity;
        this.aIT = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aIQ.destroyWaitingDialog();
        if (this.aIT) {
            this.aIQ.gn("account delete cancel");
        }
        this.aIQ.aIO = null;
    }
}
