package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class al implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aj f1122a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar) {
        this.f1122a = ajVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
