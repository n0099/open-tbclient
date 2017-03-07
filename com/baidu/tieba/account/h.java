package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aVj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountActivity accountActivity) {
        this.aVj = accountActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aVj.destroyWaitingDialog();
        this.aVj.gY("account changed");
        this.aVj.aVf = null;
    }
}
