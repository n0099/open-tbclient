package com.baidu.tieba.account;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class r implements DialogInterface.OnCancelListener {
    final /* synthetic */ q aPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.aPT = qVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        NotLoginGuideActivity notLoginGuideActivity;
        notLoginGuideActivity = this.aPT.aPS;
        notLoginGuideActivity.destroyWaitingDialog();
    }
}
