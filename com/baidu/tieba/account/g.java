package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aHO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity) {
        this.aHO = accountActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aHO.destroyWaitingDialog();
        this.aHO.go("account changed");
        this.aHO.aHL = null;
    }
}
