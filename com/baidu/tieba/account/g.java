package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity auC;
    private final /* synthetic */ boolean auF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity, boolean z) {
        this.auC = accountActivity;
        this.auF = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.auC.destroyWaitingDialog();
        if (this.auF) {
            this.auC.eT("account delete cancel");
        }
        this.auC.auB = null;
    }
}
