package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bx implements Runnable {
    final /* synthetic */ bw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar) {
        this.a = bwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            bw.a(this.a);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "run", e.toString());
        }
    }
}
