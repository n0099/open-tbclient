package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aUO;
    private final /* synthetic */ boolean aUQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aUO = accountActivity;
        this.aUQ = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aUO.destroyWaitingDialog();
        if (this.aUQ) {
            this.aUO.hr("account delete cancel");
        }
        this.aUO.aUL = null;
    }
}
