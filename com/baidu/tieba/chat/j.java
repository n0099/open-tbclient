package com.baidu.tieba.chat;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.chat.RecentChatFriendData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ ChatListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ChatListFragment chatListFragment) {
        this.a = chatListFragment;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar;
        a aVar2;
        RecentChatFriendData recentChatFriendData;
        if (i >= 0) {
            aVar = this.a.Y;
            long itemId = aVar.getItemId(i);
            if (itemId != -1 && itemId != -2) {
                ChatListFragment chatListFragment = this.a;
                aVar2 = this.a.Y;
                chatListFragment.g = (RecentChatFriendData) aVar2.getItem(i);
                ChatListFragment chatListFragment2 = this.a;
                recentChatFriendData = this.a.g;
                chatListFragment2.a(recentChatFriendData);
                if (this.a.a != null) {
                    this.a.a.show();
                }
            }
            return true;
        }
        return false;
    }
}
