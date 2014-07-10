package com.baidu.tieba.im.group;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.im.model.h hVar;
        hVar = EnterChatRoomStatic.a;
        hVar.b();
    }
}
