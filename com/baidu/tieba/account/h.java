package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aVw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountActivity accountActivity) {
        this.aVw = accountActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aVw.destroyWaitingDialog();
        this.aVw.hc("account changed");
        this.aVw.aVs = null;
    }
}
