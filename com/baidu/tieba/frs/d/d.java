package com.baidu.tieba.frs.d;

import com.baidu.tieba.frs.at;
/* loaded from: classes.dex */
class d implements Runnable {
    private final /* synthetic */ at bZV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(at atVar) {
        this.bZV = atVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bZV.ZE();
    }
}
