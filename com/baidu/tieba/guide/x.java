package com.baidu.tieba.guide;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class x implements DialogInterface.OnDismissListener {
    final /* synthetic */ u a;
    private final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar, q qVar) {
        this.a = uVar;
        this.b = qVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.b.a();
    }
}
