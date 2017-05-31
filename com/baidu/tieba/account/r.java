package com.baidu.tieba.account;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class r implements DialogInterface.OnCancelListener {
    final /* synthetic */ q aTS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.aTS = qVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        NotLoginGuideActivity notLoginGuideActivity;
        notLoginGuideActivity = this.aTS.aTR;
        notLoginGuideActivity.destroyWaitingDialog();
    }
}
