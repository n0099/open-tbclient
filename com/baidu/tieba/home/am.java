package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class am implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1158a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.f1158a = akVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
