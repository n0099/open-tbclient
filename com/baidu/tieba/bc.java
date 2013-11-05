package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1080a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(UpdateDialog updateDialog) {
        this.f1080a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f1080a.finish();
    }
}
