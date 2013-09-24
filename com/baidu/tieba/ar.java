package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ar implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f942a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(UpdateDialog updateDialog) {
        this.f942a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f942a.finish();
    }
}
