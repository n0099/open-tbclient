package com.baidu.tieba.chat;

import android.content.DialogInterface;
import com.baidu.tieba.data.chat.RecentChatFriendData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements DialogInterface.OnClickListener {
    final /* synthetic */ RecentChatFriendData a;
    final /* synthetic */ ChatListFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ChatListFragment chatListFragment, RecentChatFriendData recentChatFriendData) {
        this.b = chatListFragment;
        this.a = recentChatFriendData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.i iVar;
        switch (i) {
            case 0:
                this.b.h = 4;
                iVar = this.b.b;
                iVar.a(this.a, new l(this));
                return;
            default:
                return;
        }
    }
}
