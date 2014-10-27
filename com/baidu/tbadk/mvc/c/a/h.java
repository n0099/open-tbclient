package com.baidu.tbadk.mvc.c.a;

import android.app.Dialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class h implements DialogInterface.OnClickListener {
    final /* synthetic */ e Xz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.Xz = eVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.mvc.c.b a;
        if ((dialogInterface instanceof Dialog) && (a = com.baidu.tbadk.mvc.g.a.a((Dialog) dialogInterface)) != null) {
            Dialog dialog = (Dialog) dialogInterface;
            if (dialog.getWindow() != null) {
                a.setView(dialog.getWindow().getDecorView());
            }
            if (this.Xz.dispatchMvcEvent(a)) {
            }
        }
    }
}
