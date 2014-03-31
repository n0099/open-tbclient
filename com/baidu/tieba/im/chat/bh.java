package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bh implements View.OnClickListener {
    final /* synthetic */ GroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(GroupChatActivity groupChatActivity) {
        this.a = groupChatActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.d.Q().e();
        this.a.d.Q().setOnEggBrokeListener(new bi(this));
    }
}
