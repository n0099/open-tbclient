package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements Runnable {
    final /* synthetic */ be a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar) {
        this.a = beVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.n();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "run", e.toString());
        }
    }
}
