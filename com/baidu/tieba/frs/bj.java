package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements DialogInterface.OnClickListener {
    final /* synthetic */ bi a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.a = biVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.j jVar;
        com.baidu.tieba.j jVar2;
        if (i == 0) {
            jVar2 = this.a.a;
            com.baidu.tieba.write.bb.a(jVar2);
        } else if (i == 1) {
            jVar = this.a.a;
            com.baidu.tieba.write.bb.b(jVar);
        }
    }
}
