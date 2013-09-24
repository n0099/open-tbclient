package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class aw implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f947a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(UpdateDialog updateDialog) {
        this.f947a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f947a.finish();
    }
}
