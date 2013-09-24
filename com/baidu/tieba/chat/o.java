package com.baidu.tieba.chat;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f971a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ChatListFragment chatListFragment) {
        this.f971a = chatListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        l lVar2;
        Activity activity;
        Activity activity2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (i >= 0) {
            lVar = this.f971a.Z;
            long itemId = lVar.getItemId(i);
            if (itemId == -1) {
                i4 = this.f971a.d;
                if (i4 > 1) {
                    ChatListFragment chatListFragment = this.f971a;
                    i5 = chatListFragment.d;
                    chatListFragment.d = i5 - 1;
                    ChatListFragment chatListFragment2 = this.f971a;
                    i6 = this.f971a.d;
                    chatListFragment2.a(i6, 2);
                }
            } else if (itemId != -2) {
                lVar2 = this.f971a.Z;
                com.baidu.tieba.data.a.g gVar = (com.baidu.tieba.data.a.g) lVar2.getItem(i);
                if (TiebaApplication.g().s()) {
                    activity2 = this.f971a.c;
                    StatService.onEvent(activity2, "list_to_chat", "chatlistclick", 1);
                }
                if (gVar != null) {
                    if (gVar.f() > 0) {
                        com.baidu.tieba.mention.s.a().d(com.baidu.tieba.mention.s.a().l() - gVar.f());
                        com.baidu.tieba.mention.s.a().f();
                        gVar.b(0);
                    }
                    activity = this.f971a.c;
                    ChatActivity.a(activity, gVar.b(), gVar.g(), gVar.c(), null, "chat_list");
                    return;
                }
                com.baidu.adp.lib.f.d.e(ChatListFragment.class.getName(), "onItemClick", " RecentChatFriendData data is null");
            } else {
                ChatListFragment chatListFragment3 = this.f971a;
                i2 = chatListFragment3.d;
                chatListFragment3.d = i2 + 1;
                ChatListFragment chatListFragment4 = this.f971a;
                i3 = this.f971a.d;
                chatListFragment4.a(i3, 1);
            }
        }
    }
}
