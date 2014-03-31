package com.baidu.tieba.im.chat.snapGroup;

import android.view.View;
/* loaded from: classes.dex */
final class c implements View.OnClickListener {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.showToast(this.a.getString(com.baidu.tieba.im.j.snap_group_chat_change_group_limit_tip));
    }
}
