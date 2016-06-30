package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aLu;
    private final /* synthetic */ boolean aLw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aLu = accountActivity;
        this.aLw = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aLu.destroyWaitingDialog();
        if (this.aLw) {
            this.aLu.gH("account delete cancel");
        }
        this.aLu.aLr = null;
    }
}
