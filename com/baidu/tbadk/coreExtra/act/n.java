package com.baidu.tbadk.coreExtra.act;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class n implements DialogInterface.OnCancelListener {
    final /* synthetic */ m aby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aby = mVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        LoginActivity loginActivity;
        loginActivity = this.aby.abx;
        loginActivity.destroyWaitingDialog();
    }
}
