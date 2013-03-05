package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class at implements DialogInterface.OnClickListener {
    final /* synthetic */ ar a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar) {
        this.a = arVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
