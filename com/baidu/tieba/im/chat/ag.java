package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ GroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(GroupChatActivity groupChatActivity) {
        this.a = groupChatActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.d.O().i();
        this.a.d.O().setOnEggBrokeListener(new ah(this));
    }
}
