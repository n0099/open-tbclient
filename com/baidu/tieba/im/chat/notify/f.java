package com.baidu.tieba.im.chat.notify;
/* loaded from: classes.dex */
final class f implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b.k(this.a);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("ChatListFragment", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
