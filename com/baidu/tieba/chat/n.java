package com.baidu.tieba.chat;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class n implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListActivity f953a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ChatListActivity chatListActivity) {
        this.f953a = chatListActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        v vVar;
        v vVar2;
        com.baidu.tieba.data.a.g gVar;
        v vVar3;
        if (i >= 0) {
            vVar = this.f953a.f934a;
            long itemId = vVar.h().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                ChatListActivity chatListActivity = this.f953a;
                vVar2 = this.f953a.f934a;
                chatListActivity.f = (com.baidu.tieba.data.a.g) vVar2.h().getItem(i);
                ChatListActivity chatListActivity2 = this.f953a;
                gVar = this.f953a.f;
                chatListActivity2.a(gVar);
                vVar3 = this.f953a.f934a;
                vVar3.l();
            }
        }
        return false;
    }
}
