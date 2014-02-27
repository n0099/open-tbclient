package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s implements DialogInterface.OnClickListener {
    final /* synthetic */ m a;
    private final /* synthetic */ Object b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(m mVar, Object obj, int i) {
        this.a = mVar;
        this.b = obj;
        this.c = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        y yVar;
        yVar = this.a.Q;
        yVar.a(dialogInterface, i, this.b, this.c);
    }
}
