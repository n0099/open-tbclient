package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity awf;
    private final /* synthetic */ boolean awi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountActivity accountActivity, boolean z) {
        this.awf = accountActivity;
        this.awi = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.awf.destroyWaitingDialog();
        if (this.awi) {
            this.awf.fo("account delete cancel");
        }
        this.awf.awe = null;
    }
}
