package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aUP;
    private final /* synthetic */ boolean aUR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aUP = accountActivity;
        this.aUR = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aUP.destroyWaitingDialog();
        if (this.aUR) {
            this.aUP.hs("account delete cancel");
        }
        this.aUP.aUM = null;
    }
}
