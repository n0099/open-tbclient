package com.baidu.tieba.chat;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.chat.RecentChatFriendData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ChatListFragment chatListFragment) {
        this.f1148a = chatListFragment;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        m mVar2;
        RecentChatFriendData recentChatFriendData;
        if (i >= 0) {
            mVar = this.f1148a.aa;
            long itemId = mVar.getItemId(i);
            if (itemId != -1 && itemId != -2) {
                ChatListFragment chatListFragment = this.f1148a;
                mVar2 = this.f1148a.aa;
                chatListFragment.h = (RecentChatFriendData) mVar2.getItem(i);
                ChatListFragment chatListFragment2 = this.f1148a;
                recentChatFriendData = this.f1148a.h;
                chatListFragment2.a(recentChatFriendData);
                if (this.f1148a.f1117a != null) {
                    this.f1148a.f1117a.show();
                }
            }
        }
        return false;
    }
}
