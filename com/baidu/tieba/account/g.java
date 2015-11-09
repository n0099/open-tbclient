package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aDq;
    private final /* synthetic */ boolean aDt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity, boolean z) {
        this.aDq = accountActivity;
        this.aDt = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aDq.destroyWaitingDialog();
        if (this.aDt) {
            this.aDq.fW("account delete cancel");
        }
        this.aDq.aDp = null;
    }
}
