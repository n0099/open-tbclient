package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity amI;
    private final /* synthetic */ boolean amL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountActivity accountActivity, boolean z) {
        this.amI = accountActivity;
        this.amL = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.amI.destroyWaitingDialog();
        if (this.amL) {
            this.amI.eO("account delete cancel");
        }
        this.amI.amH = null;
    }
}
