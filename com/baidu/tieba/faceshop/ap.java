package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements Runnable {
    final /* synthetic */ ao a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.a = aoVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.f();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "run", e.toString());
        }
    }
}
