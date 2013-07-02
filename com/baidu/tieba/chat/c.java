package com.baidu.tieba.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {
    final /* synthetic */ ChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChatActivity chatActivity) {
        this.a = chatActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.data.a.d dVar;
        com.baidu.tieba.data.a.d dVar2;
        dVar = this.a.d;
        if (dVar != null) {
            dVar2 = this.a.d;
            dVar2.b(this.a);
        }
    }
}
