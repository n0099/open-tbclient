package com.baidu.tieba.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ ChatListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ChatListFragment chatListFragment) {
        this.a = chatListFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.sharedPref.b.a().b("is_shut_down_validate", true);
        this.a.f(false);
        this.a.a(false);
    }
}
