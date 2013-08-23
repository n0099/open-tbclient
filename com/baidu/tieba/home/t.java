package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f1194a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.f1194a = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.f1194a.p;
        if (z) {
            this.f1194a.j();
        }
    }
}
