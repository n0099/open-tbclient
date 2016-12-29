package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aUf;
    private final /* synthetic */ boolean aUh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aUf = accountActivity;
        this.aUh = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aUf.destroyWaitingDialog();
        if (this.aUh) {
            this.aUf.hm("account delete cancel");
        }
        this.aUf.aUc = null;
    }
}
