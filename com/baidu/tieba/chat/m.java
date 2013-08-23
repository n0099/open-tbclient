package com.baidu.tieba.chat;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class m implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListActivity f952a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ChatListActivity chatListActivity) {
        this.f952a = chatListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        v vVar;
        v vVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (i >= 0) {
            vVar = this.f952a.f934a;
            long itemId = vVar.h().getItemId(i);
            if (itemId == -1) {
                i4 = this.f952a.c;
                if (i4 > 1) {
                    ChatListActivity chatListActivity = this.f952a;
                    i5 = chatListActivity.c;
                    chatListActivity.c = i5 - 1;
                    ChatListActivity chatListActivity2 = this.f952a;
                    i6 = this.f952a.c;
                    chatListActivity2.a(i6, 2);
                }
            } else if (itemId != -2) {
                vVar2 = this.f952a.f934a;
                com.baidu.tieba.data.a.g gVar = (com.baidu.tieba.data.a.g) vVar2.h().getItem(i);
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.f952a, "list_to_chat", "chatlistclick", 1);
                }
                if (gVar != null) {
                    if (gVar.f() > 0) {
                        com.baidu.tieba.mention.r.a().d(com.baidu.tieba.mention.r.a().j() - gVar.f());
                        com.baidu.tieba.mention.r.a().e();
                        gVar.b(0);
                    }
                    ChatActivity.a(this.f952a, gVar.b(), gVar.g(), gVar.c(), null, "chat_list");
                    return;
                }
                com.baidu.adp.lib.e.d.e(ChatListActivity.class.getName(), "onItemClick", " RecentChatFriendData data is null");
            } else {
                ChatListActivity chatListActivity3 = this.f952a;
                i2 = chatListActivity3.c;
                chatListActivity3.c = i2 + 1;
                ChatListActivity chatListActivity4 = this.f952a;
                i3 = this.f952a.c;
                chatListActivity4.a(i3, 1);
            }
        }
    }
}
