package com.baidu.tieba.im.friend;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements DialogInterface.OnCancelListener {
    final /* synthetic */ IMBlackListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(IMBlackListActivity iMBlackListActivity) {
        this.a = iMBlackListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
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
