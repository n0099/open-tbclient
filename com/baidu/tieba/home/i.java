package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1152a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EnterForumActivity enterForumActivity) {
        this.f1152a = enterForumActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        try {
            nVar = this.f1152a.f1105a;
            nVar.s();
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b("HomeActivity", "mLoadImageRunnable.run", "error = " + e.getMessage());
        }
    }
}
