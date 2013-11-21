package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class al implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1396a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.f1396a = akVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
