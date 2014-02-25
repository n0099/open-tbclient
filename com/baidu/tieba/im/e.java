package com.baidu.tieba.im;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d a;
    private final /* synthetic */ a b;
    private final /* synthetic */ Object c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar, Object obj) {
        this.a = dVar;
        this.b = aVar;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b != null) {
            this.b.a(this.c);
        }
    }
}
