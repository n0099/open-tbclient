package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1274a;
    final /* synthetic */ int b;
    final /* synthetic */ ba c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ba baVar, boolean z, int i) {
        this.c = baVar;
        this.f1274a = z;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        bf bfVar;
        bfVar = this.c.L;
        bfVar.a(this.f1274a, this.b);
    }
}
