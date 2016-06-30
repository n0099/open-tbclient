package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aLu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountActivity accountActivity) {
        this.aLu = accountActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aLu.destroyWaitingDialog();
        this.aLu.gH("account changed");
        this.aLu.aLq = null;
    }
}
