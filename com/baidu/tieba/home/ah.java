package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ah implements DialogInterface.OnClickListener {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.a = agVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
