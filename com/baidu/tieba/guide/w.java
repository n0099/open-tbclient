package com.baidu.tieba.guide;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class w implements DialogInterface.OnDismissListener {
    final /* synthetic */ t a;
    private final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, p pVar) {
        this.a = tVar;
        this.b = pVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.b.a();
    }
}
