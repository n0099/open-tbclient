package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ az f1078a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(az azVar) {
        this.f1078a = azVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.g gVar;
        com.baidu.tieba.g gVar2;
        if (i == 0) {
            gVar2 = this.f1078a.d;
            com.baidu.tieba.write.ba.a(gVar2);
        } else if (i == 1) {
            gVar = this.f1078a.d;
            com.baidu.tieba.write.ba.b(gVar);
        }
    }
}
