package com.baidu.tieba.account;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class w implements DialogInterface.OnCancelListener {
    final /* synthetic */ v aMn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.aMn = vVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        NotLoginGuideActivity notLoginGuideActivity;
        notLoginGuideActivity = this.aMn.aMm;
        notLoginGuideActivity.destroyWaitingDialog();
    }
}
