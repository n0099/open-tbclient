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
        com.baidu.tieba.c.g gVar;
        com.baidu.tieba.c.g gVar2;
        try {
            gVar = this.a.d;
            if (gVar != null) {
                gVar2 = this.a.d;
                if (gVar2.d().d().size() > 0) {
                    this.a.c.v();
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("HomeActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
