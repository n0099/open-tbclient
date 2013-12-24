package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ag implements DialogInterface.OnClickListener {
    final /* synthetic */ af a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.a = afVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
