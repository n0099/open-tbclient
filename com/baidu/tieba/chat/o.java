package com.baidu.tieba.chat;
/* loaded from: classes.dex */
class o implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListActivity f954a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ChatListActivity chatListActivity) {
        this.f954a = chatListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        if (!z) {
            this.f954a.a(1, 3);
        }
    }
}
