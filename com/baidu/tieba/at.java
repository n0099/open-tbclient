package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class at implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f930a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(UpdateDialog updateDialog) {
        this.f930a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f930a.finish();
    }
}
