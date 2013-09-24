package com.baidu.tieba.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f973a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ChatListFragment chatListFragment) {
        this.f973a = chatListFragment;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        if (!z) {
            this.f973a.a(1, 3);
        }
    }
}
