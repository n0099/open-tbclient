package com.baidu.tieba.account;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class g implements DialogInterface.OnCancelListener {
    final /* synthetic */ f aet;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aet = fVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        AccountActivity accountActivity;
        accountActivity = this.aet.aeo;
        accountActivity.destroyWaitingDialog();
    }
}
