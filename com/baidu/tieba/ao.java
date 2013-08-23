package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ao implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f925a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(UpdateDialog updateDialog) {
        this.f925a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f925a.finish();
    }
}
