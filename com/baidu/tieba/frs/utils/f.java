package com.baidu.tieba.frs.utils;

import com.baidu.tieba.frs.ax;
/* loaded from: classes.dex */
class f implements Runnable {
    private final /* synthetic */ ax cbn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ax axVar) {
        this.cbn = axVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cbn.Zx();
    }
}
