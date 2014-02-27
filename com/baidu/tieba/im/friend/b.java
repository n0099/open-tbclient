package com.baidu.tieba.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements DialogInterface.OnClickListener {
    final /* synthetic */ IMBlackListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(IMBlackListActivity iMBlackListActivity) {
        this.a = iMBlackListActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.data.a aVar;
        com.baidu.tieba.im.model.b bVar;
        com.baidu.tieba.im.data.a aVar2;
        aVar = this.a.c;
        if (aVar != null) {
            r0.showLoadingDialog(null, new a(this.a));
            bVar = this.a.a;
            aVar2 = this.a.c;
            bVar.b(aVar2.a());
        }
    }
}
