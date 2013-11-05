package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bd implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1081a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(UpdateDialog updateDialog) {
        this.f1081a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1081a.finish();
    }
}
