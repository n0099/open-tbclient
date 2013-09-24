package com.baidu.tieba.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f959a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChatActivity chatActivity) {
        this.f959a = chatActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.data.a.d dVar;
        com.baidu.tieba.data.a.d dVar2;
        dVar = this.f959a.d;
        if (dVar != null) {
            dVar2 = this.f959a.d;
            dVar2.b(this.f959a);
        }
    }
}
