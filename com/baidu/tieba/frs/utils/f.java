package com.baidu.tieba.frs.utils;

import com.baidu.tieba.frs.au;
/* loaded from: classes.dex */
class f implements Runnable {
    private final /* synthetic */ au ciG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(au auVar) {
        this.ciG = auVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ciG.acT();
    }
}
