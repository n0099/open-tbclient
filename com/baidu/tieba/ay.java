package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ay implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1074a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(UpdateDialog updateDialog) {
        this.f1074a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f1074a.finish();
    }
}
