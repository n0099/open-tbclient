package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1164a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(UpdateDialog updateDialog) {
        this.f1164a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        av avVar;
        avVar = this.f1164a.c;
        avVar.dismiss();
        this.f1164a.finish();
    }
}
