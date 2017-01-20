package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aPx;
    private final /* synthetic */ boolean aPz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aPx = accountActivity;
        this.aPz = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aPx.destroyWaitingDialog();
        if (this.aPz) {
            this.aPx.hj("account delete cancel");
        }
        this.aPx.aPu = null;
    }
}
