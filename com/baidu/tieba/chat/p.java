package com.baidu.tieba.chat;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f972a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ChatListFragment chatListFragment) {
        this.f972a = chatListFragment;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        l lVar2;
        com.baidu.tieba.data.a.g gVar;
        if (i >= 0) {
            lVar = this.f972a.Z;
            long itemId = lVar.getItemId(i);
            if (itemId != -1 && itemId != -2) {
                ChatListFragment chatListFragment = this.f972a;
                lVar2 = this.f972a.Z;
                chatListFragment.g = (com.baidu.tieba.data.a.g) lVar2.getItem(i);
                ChatListFragment chatListFragment2 = this.f972a;
                gVar = this.f972a.g;
                chatListFragment2.a(gVar);
                if (this.f972a.f952a != null) {
                    this.f972a.f952a.show();
                }
            }
        }
        return false;
    }
}
