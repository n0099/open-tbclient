package com.baidu.tieba.forumfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1296a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.f1296a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.f1296a.p;
        if (z) {
            this.f1296a.l();
        }
    }
}
