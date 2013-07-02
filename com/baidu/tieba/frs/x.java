package com.baidu.tieba.frs;

import com.baidu.tieba.util.NetWorkCore;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ w a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, String str) {
        this.a = wVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        new NetWorkCore(this.b).m();
    }
}
