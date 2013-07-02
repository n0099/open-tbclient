package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements DialogInterface.OnClickListener {
    final /* synthetic */ ax a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.a = axVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.g gVar;
        com.baidu.tieba.g gVar2;
        if (i == 0) {
            gVar2 = this.a.a;
            com.baidu.tieba.write.bb.a(gVar2);
        } else if (i == 1) {
            gVar = this.a.a;
            com.baidu.tieba.write.bb.b(gVar);
        }
    }
}
