package com.baidu.tieba.group;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class c implements DialogInterface.OnCancelListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.im.model.c cVar;
        cVar = this.a.d;
        cVar.b();
    }
}
