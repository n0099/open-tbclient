package com.baidu.tieba.frs.f;

import com.baidu.tieba.frs.az;
/* loaded from: classes.dex */
class f implements Runnable {
    private final /* synthetic */ az bZO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(az azVar) {
        this.bZO = azVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bZO.ZV();
    }
}
