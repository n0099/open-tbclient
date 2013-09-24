package com.baidu.tieba.chat;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f965a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f965a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ChatActivity chatActivity;
        ac acVar;
        chatActivity = this.f965a.f964a;
        acVar = chatActivity.f951a;
        acVar.h();
    }
}
