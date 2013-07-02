package com.baidu.tieba.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ ChatListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ChatListActivity chatListActivity) {
        this.a = chatListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.d();
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("ChatListActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
