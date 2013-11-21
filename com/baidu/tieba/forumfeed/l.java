package com.baidu.tieba.forumfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1301a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.f1301a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.f1301a.p;
        if (z) {
            this.f1301a.l();
        }
    }
}
