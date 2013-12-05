package com.baidu.tieba.frs;

import com.baidu.tieba.util.NetWorkCore;
/* loaded from: classes.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1411a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.b = jVar;
        this.f1411a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        NetWorkCore netWorkCore = new NetWorkCore(new com.baidu.tieba.util.aw());
        netWorkCore.b(this.f1411a);
        netWorkCore.u();
    }
}
