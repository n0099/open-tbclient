package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cl implements DialogInterface.OnClickListener {
    final /* synthetic */ cj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(cj cjVar) {
        this.a = cjVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.a aVar;
        com.baidu.tbadk.a aVar2;
        if (i == 0) {
            aVar2 = this.a.b;
            com.baidu.tbadk.core.util.az.a(aVar2);
        } else if (i == 1) {
            aVar = this.a.b;
            com.baidu.tbadk.core.util.az.b(aVar);
        }
    }
}
