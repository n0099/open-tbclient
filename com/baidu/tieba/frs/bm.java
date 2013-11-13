package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bl f1338a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.f1338a = blVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.j jVar;
        com.baidu.tieba.j jVar2;
        if (i == 0) {
            jVar2 = this.f1338a.f1337a;
            com.baidu.tieba.write.bc.a(jVar2);
        } else if (i == 1) {
            jVar = this.f1338a.f1337a;
            com.baidu.tieba.write.bc.b(jVar);
        }
    }
}
