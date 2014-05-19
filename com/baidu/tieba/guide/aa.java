package com.baidu.tieba.guide;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class aa implements DialogInterface.OnDismissListener {
    final /* synthetic */ x a;
    private final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, t tVar) {
        this.a = xVar;
        this.b = tVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.b.a();
    }
}
