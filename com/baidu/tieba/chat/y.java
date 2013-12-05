package com.baidu.tieba.chat;

import android.content.DialogInterface;
import com.baidu.tieba.data.chat.RecentChatFriendData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecentChatFriendData f1203a;
    final /* synthetic */ ChatListFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ChatListFragment chatListFragment, RecentChatFriendData recentChatFriendData) {
        this.b = chatListFragment;
        this.f1203a = recentChatFriendData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.f fVar;
        switch (i) {
            case 0:
                this.b.i = 4;
                fVar = this.b.c;
                fVar.a(this.f1203a, new z(this));
                return;
            default:
                return;
        }
    }
}
