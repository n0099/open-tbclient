package com.baidu.tieba.frs;

import com.baidu.tieba.util.NetWorkCore;
/* loaded from: classes.dex */
class ah implements Runnable {
    final /* synthetic */ ag a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, String str) {
        this.a = agVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        NetWorkCore netWorkCore = new NetWorkCore(new com.baidu.tieba.util.bj());
        netWorkCore.b(this.b);
        netWorkCore.w();
    }
}
