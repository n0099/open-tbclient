package com.baidu.tieba.im.d;

import android.content.Context;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements DialogInterface.OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        i.b(this.a, this.b, this.c);
    }
}
