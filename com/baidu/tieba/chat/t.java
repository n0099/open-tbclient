package com.baidu.tieba.chat;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f976a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ChatListFragment chatListFragment) {
        this.f976a = chatListFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.e eVar;
        com.baidu.tieba.data.a.g gVar;
        switch (i) {
            case 0:
                this.f976a.h = 4;
                eVar = this.f976a.b;
                gVar = this.f976a.g;
                eVar.a(gVar.b());
                return;
            default:
                return;
        }
    }
}
