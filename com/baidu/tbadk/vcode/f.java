package com.baidu.tbadk.vcode;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ CommonVcodeActivity aEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CommonVcodeActivity commonVcodeActivity) {
        this.aEz = commonVcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.aEz.finish();
    }
}
