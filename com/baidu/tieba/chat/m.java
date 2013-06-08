package com.baidu.tieba.chat;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChatListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ChatListActivity chatListActivity) {
        this.a = chatListActivity;
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
            vVar = this.a.c;
            long itemId = vVar.d().getItemId(i);
            if (itemId == -1) {
                i4 = this.a.e;
                if (i4 > 1) {
                    ChatListActivity chatListActivity = this.a;
                    i5 = chatListActivity.e;
                    chatListActivity.e = i5 - 1;
                    ChatListActivity chatListActivity2 = this.a;
                    i6 = this.a.e;
                    chatListActivity2.b(i6, 2);
                }
            } else if (itemId != -2) {
                vVar2 = this.a.c;
                com.baidu.tieba.a.a.g gVar = (com.baidu.tieba.a.a.g) vVar2.d().getItem(i);
                if (gVar != null && gVar.f() > 0) {
                    TiebaApplication.d().Z();
                    gVar.b(0);
                }
                if (TiebaApplication.d().o()) {
                    StatService.onEvent(this.a, "list_to_chat", "chatlistclick", 1);
                }
                ChatActivity.a(this.a, gVar.b(), gVar.g(), gVar.c(), null, "chat_list");
            } else {
                ChatListActivity chatListActivity3 = this.a;
                i2 = chatListActivity3.e;
                chatListActivity3.e = i2 + 1;
                ChatListActivity chatListActivity4 = this.a;
                i3 = this.a.e;
                chatListActivity4.b(i3, 1);
            }
        }
    }
}
