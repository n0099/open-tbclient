package com.baidu.tieba.im.chat.snapGroup;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements DialogInterface.OnClickListener {
    final /* synthetic */ SnapGroupChatView a;
    private final /* synthetic */ SnapGroupChatActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SnapGroupChatView snapGroupChatView, SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatView;
        this.b = snapGroupChatActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.core.f.a(this.a.getContext(), "snap_chat_exit_room");
        this.b.getIntent().putExtra("need_freeze_user", true);
        this.b.finish();
    }
}
