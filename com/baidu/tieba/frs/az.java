package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ay f1135a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar) {
        this.f1135a = ayVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.j jVar;
        com.baidu.tieba.j jVar2;
        if (i == 0) {
            jVar2 = this.f1135a.f1134a;
            com.baidu.tieba.write.bf.a(jVar2);
        } else if (i == 1) {
            jVar = this.f1135a.f1134a;
            com.baidu.tieba.write.bf.b(jVar);
        }
    }
}
