package com.baidu.tieba.frs.e;

import com.baidu.tieba.frs.av;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ av cox;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(av avVar) {
        this.cox = avVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cox.aey();
    }
}
