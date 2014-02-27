package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class br implements DialogInterface.OnClickListener {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar) {
        this.a = bqVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.f fVar;
        com.baidu.tieba.f fVar2;
        if (i == 0) {
            fVar2 = this.a.a;
            com.baidu.tieba.write.by.a(fVar2);
        } else if (i == 1) {
            fVar = this.a.a;
            com.baidu.tieba.write.by.b(fVar);
        }
    }
}
