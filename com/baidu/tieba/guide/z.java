package com.baidu.tieba.guide;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class z implements DialogInterface.OnDismissListener {
    final /* synthetic */ w a;
    private final /* synthetic */ s b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar, s sVar) {
        this.a = wVar;
        this.b = sVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.b.a();
    }
}
