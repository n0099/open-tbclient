package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aHO;
    private final /* synthetic */ boolean aHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountActivity accountActivity, boolean z) {
        this.aHO = accountActivity;
        this.aHR = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aHO.destroyWaitingDialog();
        if (this.aHR) {
            this.aHO.go("account delete cancel");
        }
        this.aHO.aHM = null;
    }
}
