package com.baidu.tieba.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.f();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("ChatListFragment", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
