package com.baidu.tieba.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1171a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ChatListFragment chatListFragment) {
        this.f1171a = chatListFragment;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        if (!z) {
            this.f1171a.a(1, 3);
        }
    }
}
