package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.a = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.a();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "run", e.toString());
        }
    }
}
