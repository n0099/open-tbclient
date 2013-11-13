package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ba implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1112a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(UpdateDialog updateDialog) {
        this.f1112a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f1112a.finish();
    }
}
