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
        com.baidu.tieba.c.c cVar;
        com.baidu.tieba.a.a.g gVar;
        switch (i) {
            case 0:
                this.a.i = 4;
                cVar = this.a.d;
                gVar = this.a.h;
                cVar.b(gVar.b());
                return;
            default:
                return;
        }
    }
}
