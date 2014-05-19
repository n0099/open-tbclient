package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.i();
        } catch (Exception e) {
            BdLog.e("ChatListFragment", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
