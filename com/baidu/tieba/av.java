package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class av implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f946a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(UpdateDialog updateDialog) {
        this.f946a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f946a.finish();
    }
}
