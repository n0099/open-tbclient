package com.baidu.tieba.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ ChatListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ChatListFragment chatListFragment) {
        this.a = chatListFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.J();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("ChatListFragment", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
