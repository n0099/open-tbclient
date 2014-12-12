package com.baidu.tieba.guide;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class w implements DialogInterface.OnDismissListener {
    final /* synthetic */ t aNR;
    private final /* synthetic */ p aNS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, p pVar) {
        this.aNR = tVar;
        this.aNS = pVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.aNS.IW();
    }
}
