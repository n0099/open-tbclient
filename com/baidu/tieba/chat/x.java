package com.baidu.tieba.chat;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.chat.RecentChatFriendData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1202a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(ChatListFragment chatListFragment) {
        this.f1202a = chatListFragment;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        m mVar2;
        RecentChatFriendData recentChatFriendData;
        if (i >= 0) {
            mVar = this.f1202a.aa;
            long itemId = mVar.getItemId(i);
            if (itemId != -1 && itemId != -2) {
                ChatListFragment chatListFragment = this.f1202a;
                mVar2 = this.f1202a.aa;
                chatListFragment.h = (RecentChatFriendData) mVar2.getItem(i);
                ChatListFragment chatListFragment2 = this.f1202a;
                recentChatFriendData = this.f1202a.h;
                chatListFragment2.a(recentChatFriendData);
                if (this.f1202a.f1169a != null) {
                    this.f1202a.f1169a.show();
                }
            }
        }
        return false;
    }
}
