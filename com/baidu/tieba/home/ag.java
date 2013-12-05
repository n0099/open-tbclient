package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ag implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ af f1446a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.f1446a = afVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
