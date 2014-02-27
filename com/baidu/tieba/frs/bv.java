package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bv implements DialogInterface.OnClickListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.f fVar;
        com.baidu.tieba.f fVar2;
        if (i == 0) {
            fVar2 = this.a.d;
            com.baidu.tieba.write.by.a(fVar2);
        } else if (i == 1) {
            fVar = this.a.d;
            com.baidu.tieba.write.by.b(fVar);
        }
    }
}
