package com.baidu.tieba.im.chat.snapGroup;

import android.content.DialogInterface;
import com.baidu.tieba.ai;
/* loaded from: classes.dex */
class j implements DialogInterface.OnClickListener {
    final /* synthetic */ SnapGroupChatView a;
    private final /* synthetic */ SnapGroupChatActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SnapGroupChatView snapGroupChatView, SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatView;
        this.b = snapGroupChatActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ai.a(this.a.b(), "snap_chat_exit_room");
        this.b.getIntent().putExtra("need_freeze_user", true);
        this.b.finish();
    }
}
