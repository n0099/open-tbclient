package com.baidu.tieba.im.group;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class i implements DialogInterface.OnCancelListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.im.model.h hVar;
        hVar = EnterChatRoomStatic.a;
        hVar.b();
    }
}
