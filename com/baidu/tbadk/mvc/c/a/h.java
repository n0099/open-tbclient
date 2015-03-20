package com.baidu.tbadk.mvc.c.a;

import android.app.Dialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class h implements DialogInterface.OnClickListener {
    final /* synthetic */ e amA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.amA = eVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.mvc.c.b a;
        if ((dialogInterface instanceof Dialog) && (a = com.baidu.tbadk.mvc.h.a.a((Dialog) dialogInterface)) != null) {
            Dialog dialog = (Dialog) dialogInterface;
            if (dialog.getWindow() != null) {
                a.setView(dialog.getWindow().getDecorView());
            }
            if (this.amA.dispatchMvcEvent(a)) {
            }
        }
    }
}
