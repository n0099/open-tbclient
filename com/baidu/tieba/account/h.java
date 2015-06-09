package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity awg;
    private final /* synthetic */ boolean awj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountActivity accountActivity, boolean z) {
        this.awg = accountActivity;
        this.awj = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.awg.destroyWaitingDialog();
        if (this.awj) {
            this.awg.fo("account delete cancel");
        }
        this.awg.awf = null;
    }
}
