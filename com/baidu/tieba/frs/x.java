package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ g b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity, g gVar, int i) {
        this.a = frsActivity;
        this.b = gVar;
        this.c = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.b(this.b, this.c);
    }
}
