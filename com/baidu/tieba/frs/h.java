package com.baidu.tieba.frs;

import com.baidu.tieba.util.NetWorkCore;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, String str) {
        this.b = gVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        NetWorkCore netWorkCore = new NetWorkCore(new com.baidu.tieba.util.bl());
        netWorkCore.b(this.a);
        netWorkCore.w();
    }
}
