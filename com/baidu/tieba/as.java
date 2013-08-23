package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class as implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(UpdateDialog updateDialog) {
        this.f929a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f929a.finish();
    }
}
