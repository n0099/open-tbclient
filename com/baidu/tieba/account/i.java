package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aMo;
    private final /* synthetic */ boolean aMq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aMo = accountActivity;
        this.aMq = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aMo.destroyWaitingDialog();
        if (this.aMq) {
            this.aMo.gH("account delete cancel");
        }
        this.aMo.aMl = null;
    }
}
