package com.baidu.tieba.im.group;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class j implements DialogInterface.OnCancelListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.a = bVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.im.model.j unused;
        unused = this.a.e;
    }
}
