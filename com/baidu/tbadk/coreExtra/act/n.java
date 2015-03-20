package com.baidu.tbadk.coreExtra.act;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class n implements DialogInterface.OnCancelListener {
    final /* synthetic */ m aas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aas = mVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LoginActivity loginActivity;
        loginActivity = this.aas.aar;
        loginActivity.destroyWaitingDialog();
    }
}
