package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bd implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f921a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(UpdateDialog updateDialog) {
        this.f921a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f921a.finish();
    }
}
