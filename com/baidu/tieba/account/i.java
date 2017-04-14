package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aVw;
    private final /* synthetic */ boolean aVy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aVw = accountActivity;
        this.aVy = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aVw.destroyWaitingDialog();
        if (this.aVy) {
            this.aVw.hc("account delete cancel");
        }
        this.aVw.aVt = null;
    }
}
