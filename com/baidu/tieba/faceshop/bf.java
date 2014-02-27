package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bf implements Runnable {
    final /* synthetic */ be a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar) {
        this.a = beVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            be.a(this.a);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "run", e.toString());
        }
    }
}
