package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class u implements DialogInterface.OnClickListener {
    final /* synthetic */ MarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MarkActivity markActivity) {
        this.a = markActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.a.ae aeVar;
        switch (i) {
            case 0:
                aeVar = this.a.g;
                if (aeVar != null) {
                    this.a.i();
                    return;
                }
                return;
            case 1:
                this.a.j();
                return;
            default:
                return;
        }
    }
}
