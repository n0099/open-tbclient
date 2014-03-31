package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements DialogInterface.OnClickListener {
    final /* synthetic */ r a;
    private final /* synthetic */ Object b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar, Object obj, int i) {
        this.a = rVar;
        this.b = obj;
        this.c = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ad adVar;
        adVar = this.a.Q;
        adVar.a(dialogInterface, i, this.b, this.c);
    }
}
