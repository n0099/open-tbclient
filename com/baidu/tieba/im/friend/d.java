package com.baidu.tieba.im.friend;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class d implements DialogInterface.OnCancelListener {
    final /* synthetic */ IMBlackListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(IMBlackListActivity iMBlackListActivity) {
        this.a = iMBlackListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.im.model.b bVar;
        com.baidu.tieba.im.model.b bVar2;
        bVar = this.a.a;
        if (bVar != null) {
            bVar2 = this.a.a;
            bVar2.cancelLoadData();
            this.a.c = null;
        }
    }
}
