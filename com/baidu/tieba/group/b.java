package com.baidu.tieba.group;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class b implements DialogInterface.OnCancelListener {
    final /* synthetic */ GroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(GroupActivity groupActivity) {
        this.a = groupActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.im.model.c cVar;
        cVar = this.a.c;
        cVar.b();
    }
}
