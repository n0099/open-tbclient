package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ AccountActivity auu;
    private final /* synthetic */ boolean aux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity, boolean z) {
        this.auu = accountActivity;
        this.aux = z;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.auu.destroyWaitingDialog();
        if (this.aux) {
            this.auu.eQ("account delete cancel");
        }
        this.auu.aut = null;
    }
}
