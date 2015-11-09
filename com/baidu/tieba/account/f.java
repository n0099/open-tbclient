package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity aDq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AccountActivity accountActivity) {
        this.aDq = accountActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aDq.destroyWaitingDialog();
        this.aDq.fW("account changed");
        this.aDq.aDo = null;
    }
}
