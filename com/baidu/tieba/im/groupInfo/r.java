package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f1759a;
    final /* synthetic */ int b;
    final /* synthetic */ m c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(m mVar, Object obj, int i) {
        this.c = mVar;
        this.f1759a = obj;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        x xVar;
        xVar = this.c.G;
        xVar.a(dialogInterface, i, this.f1759a, this.b);
    }
}
