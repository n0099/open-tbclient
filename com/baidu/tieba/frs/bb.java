package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements DialogInterface.OnClickListener {
    final /* synthetic */ az a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(az azVar) {
        this.a = azVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.g gVar;
        com.baidu.tieba.g gVar2;
        if (i == 0) {
            gVar2 = this.a.d;
            com.baidu.tieba.write.bb.a(gVar2);
        } else if (i == 1) {
            gVar = this.a.d;
            com.baidu.tieba.write.bb.b(gVar);
        }
    }
}
