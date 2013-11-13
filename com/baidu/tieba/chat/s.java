package com.baidu.tieba.chat;

import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1144a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ChatListFragment chatListFragment) {
        this.f1144a = chatListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.sharedPref.b.a().b("is_shut_down_validate", true);
        this.f1144a.f(false);
        this.f1144a.a(false);
    }
}
