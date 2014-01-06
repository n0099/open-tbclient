package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DialogInterface.OnClickListener {
    final /* synthetic */ Object a;
    final /* synthetic */ int b;
    final /* synthetic */ m c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(m mVar, Object obj, int i) {
        this.c = mVar;
        this.a = obj;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        x xVar;
        xVar = this.c.I;
        xVar.a(dialogInterface, i, this.a, this.b);
    }
}
