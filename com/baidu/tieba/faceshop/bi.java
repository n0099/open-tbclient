package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements Runnable {
    final /* synthetic */ bh a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bh bhVar) {
        this.a = bhVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.n();
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.b(getClass().getName(), "run", e.toString());
        }
    }
}
