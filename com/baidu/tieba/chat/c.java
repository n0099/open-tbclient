package com.baidu.tieba.chat;
/* loaded from: classes.dex */
final class c implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a.k(this.a);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("ChatListFragment", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
