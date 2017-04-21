package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    private final /* synthetic */ boolean aVA;
    final /* synthetic */ AccountActivity aVy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aVy = accountActivity;
        this.aVA = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aVy.destroyWaitingDialog();
        if (this.aVA) {
            this.aVy.hc("account delete cancel");
        }
        this.aVy.aVv = null;
    }
}
