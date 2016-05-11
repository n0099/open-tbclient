package com.baidu.tieba.frs.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ e bup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.bup = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bup.btZ == null) {
            return;
        }
        this.bup.TG();
    }
}
