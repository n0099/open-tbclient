package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity amF;
    private final /* synthetic */ boolean amI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountActivity accountActivity, boolean z) {
        this.amF = accountActivity;
        this.amI = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.amF.destroyWaitingDialog();
        if (this.amI) {
            this.amF.eL("account delete cancel");
        }
        this.amF.amE = null;
    }
}
