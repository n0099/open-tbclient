package com.baidu.tbadk.coreExtra.act;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class o implements DialogInterface.OnCancelListener {
    final /* synthetic */ n agF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.agF = nVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LoginActivity loginActivity;
        loginActivity = this.agF.agE;
        loginActivity.destroyWaitingDialog();
    }
}
