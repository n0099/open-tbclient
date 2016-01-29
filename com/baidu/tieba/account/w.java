package com.baidu.tieba.account;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class w implements DialogInterface.OnCancelListener {
    final /* synthetic */ v aJK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.aJK = vVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        NotLoginGuideActivity notLoginGuideActivity;
        notLoginGuideActivity = this.aJK.aJJ;
        notLoginGuideActivity.destroyWaitingDialog();
    }
}
