package com.baidu.tieba.chat;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DialogInterface.OnClickListener {
    final /* synthetic */ ChatListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ChatListActivity chatListActivity) {
        this.a = chatListActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.c cVar;
        com.baidu.tieba.data.a.g gVar;
        switch (i) {
            case 0:
                this.a.g = 4;
                cVar = this.a.b;
                gVar = this.a.f;
                cVar.a(gVar.b());
                return;
            default:
                return;
        }
    }
}
