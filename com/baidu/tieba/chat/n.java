package com.baidu.tieba.chat;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class n implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListActivity f943a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ChatListActivity chatListActivity) {
        this.f943a = chatListActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        v vVar;
        v vVar2;
        com.baidu.tieba.data.a.g gVar;
        v vVar3;
        if (i >= 0) {
            vVar = this.f943a.f924a;
            long itemId = vVar.d().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                ChatListActivity chatListActivity = this.f943a;
                vVar2 = this.f943a.f924a;
                chatListActivity.f = (com.baidu.tieba.data.a.g) vVar2.d().getItem(i);
                ChatListActivity chatListActivity2 = this.f943a;
                gVar = this.f943a.f;
                chatListActivity2.a(gVar);
                vVar3 = this.f943a.f924a;
                vVar3.h();
            }
        }
        return false;
    }
}
