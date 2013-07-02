package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ EnterForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EnterForumActivity enterForumActivity) {
        this.a = enterForumActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        try {
            nVar = this.a.a;
            nVar.r();
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("HomeActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
