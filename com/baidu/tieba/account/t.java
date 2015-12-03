package com.baidu.tieba.account;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class t implements DialogInterface.OnCancelListener {
    final /* synthetic */ s aHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.aHd = sVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        NotLoginGuideActivity notLoginGuideActivity;
        notLoginGuideActivity = this.aHd.aHc;
        notLoginGuideActivity.destroyWaitingDialog();
    }
}
