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
        com.baidu.tieba.c.j jVar;
        com.baidu.tieba.c.j jVar2;
        try {
            jVar = this.a.d;
            if (jVar != null) {
                jVar2 = this.a.d;
                if (jVar2.d().d().size() > 0) {
                    this.a.c.v();
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("HomeActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
