package com.baidu.tieba.account;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class r implements DialogInterface.OnCancelListener {
    final /* synthetic */ q aFk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.aFk = qVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        NotLoginGuideActivity notLoginGuideActivity;
        notLoginGuideActivity = this.aFk.aFj;
        notLoginGuideActivity.destroyWaitingDialog();
    }
}
