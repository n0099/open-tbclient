package com.baidu.tieba.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1198a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ChatListFragment chatListFragment) {
        this.f1198a = chatListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.sharedPref.b.a().b("is_shut_down_validate", true);
        this.f1198a.f(false);
        this.f1198a.a(false);
    }
}
