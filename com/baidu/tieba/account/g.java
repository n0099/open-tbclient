package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    private final /* synthetic */ boolean aDB;
    final /* synthetic */ AccountActivity aDy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity, boolean z) {
        this.aDy = accountActivity;
        this.aDB = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aDy.destroyWaitingDialog();
        if (this.aDB) {
            this.aDy.fI("account delete cancel");
        }
        this.aDy.aDx = null;
    }
}
