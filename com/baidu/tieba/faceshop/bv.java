package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bv implements Runnable {
    final /* synthetic */ bu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar) {
        this.a = buVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            bu.a(this.a);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "run", e.toString());
        }
    }
}
