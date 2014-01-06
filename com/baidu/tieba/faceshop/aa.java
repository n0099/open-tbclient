package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class aa implements Runnable {
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
            com.baidu.adp.lib.h.e.b(getClass().getName(), "run", e.toString());
        }
    }
}
