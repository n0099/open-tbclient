package com.baidu.tieba.im;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements Runnable {
    final /* synthetic */ c a;
    private final /* synthetic */ a b;
    private final /* synthetic */ Object c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, a aVar, Object obj) {
        this.a = cVar;
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
