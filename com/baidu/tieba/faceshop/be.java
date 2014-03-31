package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class be implements Runnable {
    final /* synthetic */ bd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar) {
        this.a = bdVar;
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
