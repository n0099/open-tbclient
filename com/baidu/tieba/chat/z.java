package com.baidu.tieba.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1151a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(ChatListFragment chatListFragment) {
        this.f1151a = chatListFragment;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        if (!z) {
            this.f1151a.a(1, 3);
        }
    }
}
