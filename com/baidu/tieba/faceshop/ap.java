package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ap implements Runnable {
    final /* synthetic */ ao a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.a = aoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.baidu.tieba.util.ap.a(r0.f, this.a.i.a(), 0, -1);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "run", e.toString());
        }
    }
}
