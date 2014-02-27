package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements Runnable {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.a = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.a();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "run", e.toString());
        }
    }
}
