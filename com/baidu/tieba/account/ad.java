package com.baidu.tieba.account;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ad implements DialogInterface.OnCancelListener {
    final /* synthetic */ ac axd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.axd = acVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        NotLoginGuideActivity notLoginGuideActivity;
        notLoginGuideActivity = this.axd.axc;
        notLoginGuideActivity.destroyWaitingDialog();
    }
}
