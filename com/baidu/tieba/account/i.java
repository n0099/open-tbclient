package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aHY;
    private final /* synthetic */ boolean aIa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountActivity accountActivity, boolean z) {
        this.aHY = accountActivity;
        this.aIa = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aHY.destroyWaitingDialog();
        if (this.aIa) {
            this.aHY.gA("account delete cancel");
        }
        this.aHY.aHV = null;
    }
}
