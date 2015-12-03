package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aGn;
    private final /* synthetic */ boolean aGq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity, boolean z) {
        this.aGn = accountActivity;
        this.aGq = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aGn.destroyWaitingDialog();
        if (this.aGq) {
            this.aGn.gj("account delete cancel");
        }
        this.aGn.aGm = null;
    }
}
