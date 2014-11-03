package com.baidu.tieba.guide;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class w implements DialogInterface.OnDismissListener {
    final /* synthetic */ t aLZ;
    private final /* synthetic */ p aMa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, p pVar) {
        this.aLZ = tVar;
        this.aMa = pVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.aMa.IF();
    }
}
