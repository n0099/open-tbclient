package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f930a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EnterForumActivity enterForumActivity) {
        this.f930a = enterForumActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        try {
            nVar = this.f930a.f883a;
            nVar.r();
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("HomeActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
