package com.baidu.tieba.chat;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class n implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ ChatListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ChatListActivity chatListActivity) {
        this.a = chatListActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        v vVar;
        v vVar2;
        com.baidu.tieba.a.a.g gVar;
        v vVar3;
        if (i >= 0) {
            vVar = this.a.c;
            long itemId = vVar.d().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                ChatListActivity chatListActivity = this.a;
                vVar2 = this.a.c;
                chatListActivity.h = (com.baidu.tieba.a.a.g) vVar2.d().getItem(i);
                ChatListActivity chatListActivity2 = this.a;
                gVar = this.a.h;
                chatListActivity2.a(gVar);
                vVar3 = this.a.c;
                vVar3.h();
            }
        }
        return false;
    }
}
