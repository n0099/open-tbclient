package com.baidu.tieba.im;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements Runnable {
    final /* synthetic */ n a;
    private final /* synthetic */ a b;
    private final /* synthetic */ Object c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, a aVar, Object obj) {
        this.a = nVar;
        this.b = aVar;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b != null) {
            this.b.a(this.c);
        }
    }
}
