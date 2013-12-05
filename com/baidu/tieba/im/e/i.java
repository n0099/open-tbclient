package com.baidu.tieba.im.e;

import android.content.Context;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f1692a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, String str, String str2) {
        this.f1692a = context;
        this.b = str;
        this.c = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        h.b(this.f1692a, this.b, this.c);
    }
}
