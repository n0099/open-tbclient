package com.baidu.tbadk.coreExtra.act;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class n implements DialogInterface.OnCancelListener {
    final /* synthetic */ m aau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aau = mVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LoginActivity loginActivity;
        loginActivity = this.aau.aat;
        loginActivity.destroyWaitingDialog();
    }
}
