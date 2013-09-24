package com.baidu.tieba.forumfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1104a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f1104a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.f1104a.o;
        if (z) {
            this.f1104a.j();
        }
    }
}
