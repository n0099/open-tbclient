package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bg implements Runnable {
    final /* synthetic */ bf a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar) {
        this.a = bfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.baidu.tbadk.core.util.ac.a(r0.f, this.a.i.a(), 0, -1);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "run", e.toString());
        }
    }
}
