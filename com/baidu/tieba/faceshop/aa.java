package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.a = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.a();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "run", e.toString());
        }
    }
}
