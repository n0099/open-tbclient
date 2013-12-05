package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1396a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bn bnVar) {
        this.f1396a = bnVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.j jVar;
        com.baidu.tieba.j jVar2;
        if (i == 0) {
            jVar2 = this.f1396a.d;
            com.baidu.tieba.write.bd.a(jVar2);
        } else if (i == 1) {
            jVar = this.f1396a.d;
            com.baidu.tieba.write.bd.b(jVar);
        }
    }
}
