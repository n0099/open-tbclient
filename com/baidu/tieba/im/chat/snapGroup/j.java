package com.baidu.tieba.im.chat.snapGroup;

import android.content.DialogInterface;
import com.baidu.tieba.ao;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements DialogInterface.OnClickListener {
    final /* synthetic */ SnapGroupChatActivity a;
    final /* synthetic */ SnapGroupChatView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SnapGroupChatView snapGroupChatView, SnapGroupChatActivity snapGroupChatActivity) {
        this.b = snapGroupChatView;
        this.a = snapGroupChatActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ao.a(this.b.b(), "snap_chat_exit_room");
        this.a.getIntent().putExtra("need_freeze_user", true);
        this.a.finish();
    }
}
