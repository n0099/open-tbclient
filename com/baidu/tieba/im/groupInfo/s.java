package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f1614a;
    final /* synthetic */ int b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(n nVar, Object obj, int i) {
        this.c = nVar;
        this.f1614a = obj;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        y yVar;
        yVar = this.c.G;
        yVar.a(dialogInterface, i, this.f1614a, this.b);
    }
}
