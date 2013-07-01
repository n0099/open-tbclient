package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class be implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(UpdateDialog updateDialog) {
        this.f710a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f710a.finish();
    }
}
