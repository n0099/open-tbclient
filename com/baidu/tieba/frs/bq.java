package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements DialogInterface.OnClickListener {
    final /* synthetic */ bp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.a = bpVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.f fVar;
        com.baidu.tieba.f fVar2;
        if (i == 0) {
            fVar2 = this.a.a;
            com.baidu.tieba.write.bz.a(fVar2);
        } else if (i == 1) {
            fVar = this.a.a;
            com.baidu.tieba.write.bz.b(fVar);
        }
    }
}
