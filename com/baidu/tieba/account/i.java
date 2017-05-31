package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aTw;
    private final /* synthetic */ boolean aTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aTw = accountActivity;
        this.aTy = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aTw.destroyWaitingDialog();
        if (this.aTy) {
            this.aTw.gV("account delete cancel");
        }
        this.aTw.aTt = null;
    }
}
