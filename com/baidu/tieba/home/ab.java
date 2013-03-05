package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ab implements DialogInterface.OnClickListener {
    final /* synthetic */ MarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MarkActivity markActivity) {
        this.a = markActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.a.ac acVar;
        switch (i) {
            case 0:
                acVar = this.a.h;
                if (acVar == null) {
                    return;
                }
                this.a.k();
                return;
            case 1:
                this.a.l();
                return;
            default:
                return;
        }
    }
}
