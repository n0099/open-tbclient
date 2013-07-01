package com.baidu.tieba.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListActivity f736a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ChatListActivity chatListActivity) {
        this.f736a = chatListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f736a.d();
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("ChatListActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
