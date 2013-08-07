package com.baidu.tieba.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f932a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChatActivity chatActivity) {
        this.f932a = chatActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.data.a.d dVar;
        com.baidu.tieba.data.a.d dVar2;
        dVar = this.f932a.d;
        if (dVar != null) {
            dVar2 = this.f932a.d;
            dVar2.b(this.f932a);
        }
    }
}
