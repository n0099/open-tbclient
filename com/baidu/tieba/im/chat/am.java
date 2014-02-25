package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ GroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(GroupChatActivity groupChatActivity) {
        this.a = groupChatActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.d.Q().i();
        this.a.d.Q().setOnEggBrokeListener(new an(this));
    }
}
