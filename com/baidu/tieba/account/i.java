package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aVj;
    private final /* synthetic */ boolean aVl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aVj = accountActivity;
        this.aVl = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aVj.destroyWaitingDialog();
        if (this.aVl) {
            this.aVj.gY("account delete cancel");
        }
        this.aVj.aVg = null;
    }
}
