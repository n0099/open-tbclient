package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class be implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f922a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(UpdateDialog updateDialog) {
        this.f922a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f922a.finish();
    }
}
